package ru.sber.projectATM.core.subFunction;

import ru.sber.projectATM.core.exceptoin.RegExpFormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilsForCard {
    private static Pattern patternPan = Pattern.compile("^(\\d{4})(\\d{4,10})(\\d{4})$");

    private static String repeatWord(int count, String with) {
        return new String(new char[count]).replace("*", with);
    }

    public static String wrapPan(String pan) {
        Matcher matcherPan = patternPan.matcher(String.valueOf(pan));
        return pan.replaceAll(matcherPan.group(2), repeatWord(matcherPan.group(2).length(), "*"));
    }


    public static boolean regExpValidator(String value, String patternForValidate) {
        Pattern pattern = Pattern.compile(patternForValidate);
        Matcher matcherPan = pattern.matcher(String.valueOf(value));
        if (matcherPan.find()) {
            return true;
        } else {
            return false;
        }
    }

}
