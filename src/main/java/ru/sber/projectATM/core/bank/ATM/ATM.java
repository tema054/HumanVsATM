package ru.sber.projectATM.core.bank.ATM;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.sber.projectATM.core.bank.ATM.validate.LogWrapper;
import ru.sber.projectATM.core.bank.accounting.BalanceResponse;
import ru.sber.projectATM.core.bank.front.FrontSystem;
import ru.sber.projectATM.core.bank.front.FrontSystemNotAvailable;
import ru.sber.projectATM.core.handbook.Status;
import ru.sber.projectATM.core.bank.ATM.validate.СardValidator;

import java.util.function.*;


@Slf4j
@Component("ATM")
public class ATM {


    private FrontSystem frontABS = new FrontSystem();

    //счётчик операций на банкомате
    private int authId = 0;

    private Supplier<BalanceResponse> supplierBalanceResponse() {
        return () -> new BalanceResponse();
    }

    public BalanceResponse getBalance(String pan, int pin) {
        //счётчик авторизаций
        BalanceResponse balance = supplierBalanceResponse().get();
        try {
            frontABS.checkConnect();
            authId++;
            //проверяем формат PAN
            //СardValidator.validate(pan, СardValidator.regexpPan);
            //проверка PAN прошла успешна, маскируем значение
            String wrapPan = LogWrapper.wrapPan(pan);
            log.info(String.format("authId: %d pan %s %s", authId, wrapPan, "IsCorrect"));
            //проверяем формат PIN
            //СardValidator.validate(String.valueOf(pin), СardValidator.regexpPin);

            balance = frontABS.getBalance(pan, pin);
            log.info(String.format("authId: %d pan %s  %s ", authId, wrapPan, balance.toString()));

        } catch (FrontSystemNotAvailable ex) {
            log.error(String.format("%s %s", "АС не доступна", ex.getMessage()));
            //todo: сделать частью шаблона
            balance.setRC(Status.FAILED);
        }
        return balance;
    }
}




