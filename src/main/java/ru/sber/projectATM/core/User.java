package ru.sber.projectATM.core;

import lombok.AllArgsConstructor;
import lombok.Setter;
import ru.sber.projectATM.core.accounting.BalanceRequest;


@AllArgsConstructor
public class User {
    @Setter
    private String pan;
    @Setter
    private int pin;

    // переделать гет беленс
    public BalanceRequest getBalance(ATM atm) {
        return atm.getBalance(pan, pin);

    }
}
