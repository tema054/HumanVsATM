package ru.sber.projectATM.core;

import java.util.*;
import java.util.function.*;

import ru.sber.projectATM.core.bank.ATM.ATM;
import ru.sber.projectATM.core.bank.ATM.validate.СardValidator;

public class Main {
    public static void main(String[] args) {

        User user = new User("1111222233134444", -1);


        System.out.println(user.getBalance(new ATM()).toString());

        user.setPin(2222);

        System.out.println(user.getBalance(new ATM()).toString());
        user.setPan("4111222233134444");


        user.setPin(2222);
        System.out.println(user.getBalance(new ATM()).toString());


        ArrayList<String> cardList = new ArrayList<>();
        cardList.add("1111222233134444");
        cardList.add("4111222233134444");
        cardList.add("adasd444");


        //пример высосанный из пальца, но пока я не понимаю куда ещё прикрутить проверку
        System.out.println(СardValidator.volatileListCard(cardList, СardValidator.validatePredicate(СardValidator.regexpPan)));

    }
}
