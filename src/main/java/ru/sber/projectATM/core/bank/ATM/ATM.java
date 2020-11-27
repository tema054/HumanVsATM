package ru.sber.projectATM.core.bank.ATM;

import lombok.extern.slf4j.Slf4j;
import ru.sber.projectATM.core.accounting.BalanceRequest;
import ru.sber.projectATM.core.bank.FrontSystem;
import ru.sber.projectATM.core.subFunction.UtilsForCard;

@Slf4j
public class ATM {
    private FrontSystem =new
    private static final String regexpPan = "^(\\d{4})(\\d{4,10})(\\d{4})$";
    private static final String regexpPin = "^\\d{4,6}$";
    //счётчик операций на банкомате
    private static int authId = 0;

    FrontSystem();

    public BalanceRequest getBalance(String pan, int pin) {
        //счётчик авторизаций
        authId++;
        BalanceRequest balance = new BalanceRequest();
        String wrapPan;
        UtilsForCard.regExpValidator(pan, regexpPan);
        wrapPan = UtilsForCard.wrapPan(pan);
        log.info(String.format("authId: %d pan %s %s", authId, wrapPan, "IsCorrect"));
        UtilsForCard.regExpValidator(String.valueOf(pin), regexpPin);
        log.info(String.format("authId: %d pan %s  %s ", authId, wrapPan, balance.toString()));
        return balance;
    }
}
   /*пока условие немного притянуто за уши по позже можно сделать патерн сбольшим
            количеством групп и по ним понимать что за продукт*/
//            if (matcherPan.group(1).matches("^[^2,4-6].*")) {
//                balance.setResponseСode("Not supported BIN");
//                balance.setStatus(Status.FAILED);
//                log.info(String.format("authId: %d check BIN: %s ", authId, "Not supported BIN"));
//                return balance;
//            }
//todo:вынести логику обработки бинов на уровень сущности БАНК



