package ru.sber.projectATM.core;

import ru.sber.projectATM.core.bank.ATM.ATM;

public class Main {
    public static void main(String[] args) {

        User user = new User("1111222233134444", -1);


        System.out.println(user.getBalance(new ATM()).toString());

        user.setPan("4111222233134444");


        System.out.println(user.getBalance(new ATM()).toString());


        user.setPin(2222);
        System.out.println(user.getBalance(new ATM()).toString());


    }
}
