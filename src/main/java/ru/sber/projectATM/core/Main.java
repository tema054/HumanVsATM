package ru.sber.projectATM.core;

import java.util.*;
import java.util.function.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.sber.projectATM.core.bank.ATM.ATM;
import ru.sber.projectATM.core.bank.ATM.validate.СardValidator;

@ComponentScan(basePackages = "ru.sber.projectATM.core")
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        User user = context.getBean("user", User.class);
        ATM atm = context.getBean("ATM", ATM.class);
        System.out.println(user.getBalance(atm).toString());



        /*
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
        */

    }
}
