package ru.sber.projectATM.core;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ru.sber.projectATM.core.accounting.BalanceRequest;
import ru.sber.projectATM.core.accounting.Currency;
import ru.sber.projectATM.core.accounting.Status;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class ATM {
    private static final String regexpPan = "^(\\d{4})(\\d{4,14}$)";
    private static final String regexpPin = "^\\d{4,6}$";
    //счётчик операций на банкомате
    private static int authId = 0;
    @Setter
    private String pan;

    @Setter
    private int pin;

    public BalanceRequest getBalance(String pan, int pin) {
        authId++;
        log.info(String.format("authId: %d pan %s pin %s", authId, pan, pin));
        BalanceRequest balance = new BalanceRequest();

        Pattern patternPan = Pattern.compile(regexpPan);
        Matcher matcherPan = patternPan.matcher(String.valueOf(pan));

        if (matcherPan.find()) {
            log.info(String.format("authId: %d pan %s %s", authId, pan, "IsCorrect"));
            /*пока условие немного притянуто за уши по позже можно сделать патерн сбольшим
            количеством групп и по ним понимать что за продукт*/
            if (matcherPan.group(1).matches("^[^2,4-6].*")) {
                balance.setResponseСode("Not supported BIN");
                balance.setStatus(Status.FAILED);
                log.info(String.format("authId: %d check BIN: %s ", authId, "Not supported BIN"));
                return balance;
            }
            //todo:вынести логику обработки бинов на уровень сущности БАНК

            log.info(String.format("authId: %d pan %s %s", authId, pan, "IsCorrect"));
            if (String.valueOf(pin).matches(regexpPin)) {
                balance.setAvailableAmount(22.22);
                balance.setCurrency(Currency.RUR);
                balance.setStatus(Status.SUCCESS);
                balance.setResponseСode("0");
                log.info(String.format("authId: %d pan %s ", authId, pan, balance.toString()));
                return balance;
            } else {
                balance.setResponseСode("Invalid pin, try again");
                balance.setStatus(Status.FAILED);
                log.info(String.format("authId: %d %s", authId, "Invalid pin, try again"));
                return balance;
            }
        }

        balance.setResponseСode("Undefined Exception");
        balance.setStatus(Status.FAILED);
        log.info(String.format("authId: %d %s", authId, "Undefined Exception"));

        return balance;
    }
}

