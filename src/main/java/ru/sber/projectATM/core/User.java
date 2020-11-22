package ru.sber.projectATM.core;

import lombok.AllArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
public class User {
    @Setter
    private String pan;
    @Setter
    private int pin;

    public BalanceRequest getBalance(ATM atm) {
        atm.setPan(pan);
        atm.setPin(pin);
        return atm.getBalance(pan, pin);

    }
}
