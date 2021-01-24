package ru.sber.projectATM.AutomatedTellerMachine.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.sber.projectATM.AutomatedTellerMachine.dto.BalanceDTO;
import ru.sber.projectATM.AutomatedTellerMachine.exception.ATMInternalErrorException;
import ru.sber.projectATM.AutomatedTellerMachine.service.ATMService;
import ru.sber.projectATM.AutomatedTellerMachine.validate.*;
import ru.sber.projectATM.common.*;


import ru.sber.projectATM.common.handbook.*;
import ru.sber.projectATM.common.handbook.Currency;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.sql.Array;
import java.util.function.*;
import java.util.*;

@Slf4j
@RestController

public class controllerATM {

    private String pan;
    private ATMService atmService = new ATMService();
    //счётчик операций на банкомате
    private int authId = 0;

    Balance balance = supplierBalanceResponse().get();

    private Supplier<Balance> supplierBalanceResponse() {
        return () -> new Balance(0d, Currency.RUR);
    }

    @GetMapping({"atm/"})
    public String getBalance() {
        return "ATM ready";
    }

    //http://127.0.0.1:8080/atm/pan/4321123412344321/pin/0000
    @GetMapping({"atm/pan/{PAN}/pin/{PIN}", "atm/pan/{PAN}/pin/{PIN}/ATM/{id}"})
    public BalanceDTO getBalance(
            @Pattern(regexp = "^(\\d{4})(\\d{4,10})(\\d{4})$")
            @PathVariable("PAN") String pan,

            @Pattern(regexp = "^\\d{4,6}$")
            @Min(0000)
            @Max(9999)
            @PathVariable("PIN") int pin,

            @PathVariable(required = false) Integer id) {

        List<Integer> ATMlist = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        if (ATMlist.stream().anyMatch(o -> o.equals(id))) {
            throw new ATMInternalErrorException("ATM not ready");
        }


        try {
            //  frontABS.checkConnect();
            authId++;

            String wrapPan = LogWrapper.wrapPan(pan);
            log.info(String.format("authId: %d pan %s %s", authId, wrapPan, "IsCorrect"));

            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<Request> request = new HttpEntity<>(new Request(1, pan, pin));

            ResponseEntity<String> responseEntity = restTemplate.
                    postForEntity("http://127.0.0.1:8090/bank/1/getBalance/", request, String.class);

            //   Balance balance = restTemplate.postForObject("http://127.0.0.1:8090/bank/1/getBalance/" , request, Balance.class);

            log.info(String.format("authId: %d pan %s  %s ", authId, wrapPan, balance.toString()));
            // log.info(balance.toString());
            log.info(responseEntity.getBody().toString());

        } catch (Exception ex) {//FrontSystemNotAvailable
            log.error(String.format("%s %s", "Ошибка при обращении", ex.getMessage()));
            throw ex;
        }
        return atmService.getClientBalance(balance, Status.SUCCESS);
    }
}




