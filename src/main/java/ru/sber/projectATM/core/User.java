package ru.sber.projectATM.core;

import lombok.AllArgsConstructor;
import lombok.Setter;
import ru.sber.projectATM.core.accounting.BalanceRequest;

@Setter
@AllArgsConstructor
public class User {
    private String pan;
    private int pin;

    // переделать гет беленс
    public BalanceRequest getBalance(ATM atm) {
        return atm.getBalance(pan, pin);

    }
}
