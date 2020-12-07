package ru.sber.projectATM.core.bank.ATM.validate;

import lombok.extern.slf4j.Slf4j;
import ru.sber.projectATM.core.bank.ATM.validate.exceptoin.RegExpFormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j

public class cardValidator {

    public static final String regexpPan = "^(\\d{4})(\\d{4,10})(\\d{4})$";
    public static final String regexpPin = "^\\d{4,6}$";

    public static void validate(String value, String patternForValidate) {
        Pattern pattern = Pattern.compile(patternForValidate);
        Matcher matcherValue = pattern.matcher(value);
        if (!matcherValue.find()) {
            log.error(String.format("Значение %s не прошло вадидация %s", value, pattern), new RegExpFormatException());
        }
    }

}
