package ru.sber.projectATM.core;

import lombok.AllArgsConstructor;
import lombok.Setter;
import ru.sber.projectATM.core.bank.accounting.BalanceResponse;
import ru.sber.projectATM.core.bank.ATM.ATM;

@Setter
@AllArgsConstructor
public class User {
    private String pan;
    private int pin;

    public BalanceResponse getBalance(ATM atm) {
        return atm.getBalance(pan, pin);
    }
}
