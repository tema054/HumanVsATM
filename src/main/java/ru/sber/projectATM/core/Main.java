package ru.sber.projectATM.core;

import java.util.HashMap;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {

        User user = new User(new BigInteger("1111222233134444"), -1);
        user.setAtm(new ATM());
        System.out.println(user.getBalance().get("status"));
        user.setPin(2222);
        HashMap map = user.getBalance();
        System.out.printf("%s %s %s",
                map.get("availableAmount"),
                map.get("currency"),
                map.get("status"));
    }
}
