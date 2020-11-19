package ru.sber.projectATM.core;

import ru.sber.projectATM.core.abiliti.BalanceRequest;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Optional;

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
    public Optional<HashMap<String, String>> getBalance() {
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
                return Optional.of(balance);
            }
        }
        balance.put("status", "failed");
        return Optional.of(balance);
        //todo: придумать как сделать по красоте
    }
}
