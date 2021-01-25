package ru.sber.projectATM.bank.controller;

import lombok.Getter;
import lombok.Setter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.sber.projectATM.bank.exception.FrontSystemNotAvailable;
import ru.sber.projectATM.common.*;
import ru.sber.projectATM.common.handbook.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;


@Getter
@Setter
@Slf4j
@RestController

public class FrontSystemController {
    private boolean isOnline = true;

    public void checkConnect() throws FrontSystemNotAvailable {
        if (!isOnline) {
            new FrontSystemNotAvailable();
        }
    }


    @PostMapping({"bank/1/getBalance/"})
    public Balance getBalance(@RequestBody Request request) {

        log.info(String.format("%s %s %s", "use method getBalance", request.getPIN(), request.getPAN()));
        DefaultAccount defaultAccount = new DefaultAccount(2, request.getPAN(), new Balance(100.00, Currency.RUR));
        Client<DefaultAccount> defaultAccountClient = new Client<DefaultAccount>(2, defaultAccount);
        log.info(String.format("%s %s ", "getBalance return getBalane  ", defaultAccountClient.getAccount().getDefaultBalance().toString()));

        return defaultAccountClient.getAccount().getDefaultBalance();
    }
}
