package ru.sber.projectATM.core;

import java.util.HashMap;
import java.math.BigInteger;
import java.util.Optional;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {

        User user = new User(new BigInteger("1111222233134444"), -1);
        user.setAtm(new ATM());

        System.out.println(user.getBalance().get().get("status"));
        //todo: не понятно как без get забрать значение
        user.setPin(2222);
        Optional<HashMap<String, String>> map = user.getBalance();


        System.out.printf("%s %s %s",
                map.get().get("availableAmount"),
                map.get().get("currency"),
                map.get().get("status"));
        //todo: тут вроде может пойти чтото не так
    }
}
