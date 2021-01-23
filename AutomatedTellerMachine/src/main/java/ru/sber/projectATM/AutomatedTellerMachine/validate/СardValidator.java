package ru.sber.projectATM.AutomatedTellerMachine.validate;

import lombok.extern.slf4j.Slf4j;
import ru.sber.projectATM.AutomatedTellerMachine.validate.exceptoin.RegExpFormatException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.function.*;
import java.util.stream.Collectors;

@Slf4j

public class СardValidator {

    public static final String regexpPan = "^(\\d{4})(\\d{4,10})(\\d{4})$";
    public static final String regexpPin = "^\\d{4,6}$";

    public static void validate(String value, String patternForValidate) {
        Pattern pattern = Pattern.compile(patternForValidate);
        Matcher matcherValue = pattern.matcher(value);
        if (!matcherValue.find()) {
            log.error(String.format("Значение %s не прошло вадидация %s", value, pattern), new RegExpFormatException());
        }
    }

    public static Predicate<String> validatePredicate(String pattern) {
        return s -> s.matches(pattern);
    }

    //пример высосанный из пальца, но пока я не понимаю куда ещё прикрутить проверку
    public static List<String> volatileListCard(List<String> listPan, Predicate<String> predicate) {
        return listPan.stream().filter(predicate).collect(Collectors.toList());
    }

}
