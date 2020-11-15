package ru.sber.projectATM.core;

import ru.sber.projectATM.core.abiliti.BalanceRequest;

import java.math.BigInteger;
import java.util.HashMap;

public class User implements BalanceRequest {
    private BigInteger pan;
    private int pin;
    private ATM atm;

    public User(BigInteger pan, int pin) {
        this.pan = pan;
        this.pin = pin;
    }

    public void setPan(BigInteger pan) {
        this.pan = pan;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void setAtm(ATM atm) {
        this.atm = atm;
    }

    @Override
    public HashMap<String, String> getBalance() {
        if (atm != null) {
            atm.setPan(pan);
            atm.setPin(pin);
            return atm.getBalance();
        }
        return null;
        //todo: придумать как это сделать красивее
        //todo: обработку исключений

    }
}
