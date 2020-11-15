package ru.sber.projectATM.core;

import ru.sber.projectATM.core.abiliti.BalanceRequest;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ATM implements BalanceRequest {
    private BigInteger pan;
    private int pin;

    public void setPan(BigInteger pan) {
        this.pan = pan;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public HashMap<String, String> getBalance() {
        HashMap<String, String> balance = new HashMap<>();
        balance.put("availableAmount", null);
        balance.put("currency", null);
        balance.put("status", null);

        String regexpPan = "^\\d{16,18}";
        String regexpPin = "^\\d{4,6}";
        Pattern patternPan = Pattern.compile(regexpPan);
        Matcher matcherPan = patternPan.matcher(String.valueOf(pan));
        Pattern patternPin = Pattern.compile(regexpPin);
        Matcher matcherPin = patternPin.matcher(String.valueOf(pin));
        if (matcherPan.find()) {
            if (matcherPin.find()) {
                balance.put("availableAmount", String.valueOf(222.22));
                balance.put("currency", "RUR");
                balance.put("status", "success");
                return balance;
            }
        }
        //todo: добавить инициацию исключений
        balance.put("status", "failed");
        return balance;
    }
}
