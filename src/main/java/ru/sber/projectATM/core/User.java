package ru.sber.projectATM.core;

import ru.sber.projectATM.core.abiliti.BalanceRequest;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Optional;

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
    public Optional<HashMap<String, String>> getBalance() {
        atm.setPan(pan);
        atm.setPin(pin);
        return atm.getBalance();
        //todo: придумать как это сделать красивее
        //todo: обработку исключений

    }
}
