package ru.sber.projectATM.core.bank.ATM;

import lombok.extern.slf4j.Slf4j;
import ru.sber.projectATM.core.bank.ATM.validate.LogWrapper;
import ru.sber.projectATM.core.bank.accounting.BalanceResponse;
import ru.sber.projectATM.core.bank.front.FrontSystem;
import ru.sber.projectATM.core.bank.front.FrontSystemNotAvailable;
import ru.sber.projectATM.core.handbook.Status;
import ru.sber.projectATM.core.bank.ATM.validate.RegExpValidator;

@Slf4j
public class ATM {
    private FrontSystem frontABS = new FrontSystem();

    //счётчик операций на банкомате
    private int authId = 0;

    public BalanceResponse getBalance(String pan, int pin) {
        //счётчик авторизаций
        BalanceResponse balance = new BalanceResponse();
        try {
            frontABS.checkConnect();
            authId++;
            //проверяем формат PAN
            RegExpValidator.validate(pan, RegExpValidator.regexpPan);
            //проверка PAN прошла успешна, маскируем значение
            String wrapPan = LogWrapper.wrapPan(pan);
            log.info(String.format("authId: %d pan %s %s", authId, wrapPan, "IsCorrect"));
            //проверяем формат PIN
            RegExpValidator.validate(String.valueOf(pin), RegExpValidator.regexpPin);
            log.info(String.format("authId: %d pan %s  %s ", authId, wrapPan, balance.toString()));
            balance = frontABS.getBalance(pan, pin);
        } catch (FrontSystemNotAvailable ex) {
            log.info("АС не доступна");
            balance.setRC(Status.FAILED);
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



