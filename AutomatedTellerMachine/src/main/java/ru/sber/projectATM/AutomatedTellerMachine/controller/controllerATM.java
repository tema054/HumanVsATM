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
import ru.sber.projectATM.AutomatedTellerMachine.exception.ATMInternalErrorException;
import ru.sber.projectATM.AutomatedTellerMachine.service.ATMService;
import ru.sber.projectATM.AutomatedTellerMachine.validate.*;
import ru.sber.projectATM.common.*;


import ru.sber.projectATM.common.handbook.*;


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

    private Supplier<BalanceResponse> supplierBalanceResponse() {
        return () -> new BalanceResponse();
    }

    @GetMapping({"/pan/{PAN}/pin/{PIN}", "/pan/{PAN}/pin/{PIN}/ATM/{id}"})
    public BalanceResponse getBalance(
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
            //проверяем формат PAN
            //СardValidator.validate(pan, СardValidator.regexpPan);
            //проверка PAN прошла успешна, маскируем значение
            String wrapPan = LogWrapper.wrapPan(pan);
            log.info(String.format("authId: %d pan %s %s", authId, wrapPan, "IsCorrect"));
            //проверяем формат PIN
            //СardValidator.validate(String.valueOf(pin), СardValidator.regexpPin);
            //  balance = frontABS.getBalance(pan, pin);

            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<Request> request = new HttpEntity<>(new Request(1, pan, pin));


            ResponseEntity<String> responseEntityStr = restTemplate.
                    postForEntity("http://127.0.0.1:8080/hosts/1/clients/" + clientId,
                            request, String.class);

            BalanceResponse balance = supplierBalanceResponse().get();
            log.info(String.format("authId: %d pan %s  %s ", authId, wrapPan, balance.toString()));

        } catch (Exception ex) {//FrontSystemNotAvailable
            log.error(String.format("%s %s", "АС не доступна", ex.getMessage()));
            //todo: сделать частью шаблона
            balance.setRC(Status.FAILED);
        }
        return balance;
    }
}




