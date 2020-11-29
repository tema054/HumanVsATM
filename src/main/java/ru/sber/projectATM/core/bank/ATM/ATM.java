package ru.sber.projectATM.core.bank.ATM;

import lombok.extern.slf4j.Slf4j;
import ru.sber.projectATM.core.accounting.BalanceRequest;
import ru.sber.projectATM.core.bank.front.FrontSystem;
import ru.sber.projectATM.core.handbook.Status;
import ru.sber.projectATM.core.subFunction.UtilsForCard;

@Slf4j
public class ATM {
    private FrontSystem frontABS = new FrontSystem();

    //счётчик операций на банкомате
    private static int authId = 0;

    public BalanceRequest getBalance(String pan, int pin) {
        //счётчик авторизаций
        BalanceRequest balance = new BalanceRequest();
        if (frontABS.checkConnect()) {
            authId++;
            String wrapPan;
            //проверяем формат PAN
            UtilsForCard.regExpValidator(pan, UtilsForCard.regexpPan);
            //проверка PAN прошла успешна, маскируем значение
            wrapPan = UtilsForCard.wrapPan(pan);
            log.info(String.format("authId: %d pan %s %s", authId, wrapPan, "IsCorrect"));
            //проверяем формат PIN
            UtilsForCard.regExpValidator(String.valueOf(pin), UtilsForCard.regexpPin);
            log.info(String.format("authId: %d pan %s  %s ", authId, wrapPan, balance.toString()));
        } else {
            balance.setRC(Status.FAILED);
            balance.setDescriptionRC("checkConnect failed");
        }
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



