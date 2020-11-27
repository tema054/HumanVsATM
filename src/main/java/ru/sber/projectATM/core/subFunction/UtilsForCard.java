package ru.sber.projectATM.core.subFunction;

import lombok.extern.slf4j.Slf4j;
import ru.sber.projectATM.core.subFunction.exceptoin.RegExpFormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j

public class UtilsForCard {
    private static Pattern patternPan = Pattern.compile("^(\\d{4})(\\d{4,10})(\\d{4})$");

    private static String repeatWord(int count, String with) {
        return new String(new char[count]).replace("*", with);
    }

    public static String wrapPan(String pan) {
        Matcher matcherPan = patternPan.matcher(String.valueOf(pan));
        if (!matcherPan.find()) {
            log.error(String.format("PAN %s не прошёл вадидацию и не может быть замаскирован", pan), new RegExpFormatException());
        }
        return pan.replaceAll(matcherPan.group(2), repeatWord(matcherPan.group(2).length(), "*"));
    }


    public static void regExpValidator(String value, String patternForValidate) {
        Pattern pattern = Pattern.compile(patternForValidate);
        Matcher matcherValue = pattern.matcher(String.valueOf(value));
        if (!matcherValue.find()) {
            log.error(String.format("Значение %s не прошло вадидация %s", value, pattern), new RegExpFormatException());
        }
    }

}