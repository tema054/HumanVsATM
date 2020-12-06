package ru.sber.projectATM.core.bank.ATM.validate;

import lombok.extern.slf4j.Slf4j;
import ru.sber.projectATM.core.bank.ATM.validate.exceptoin.RegExpFormatException;

import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j

public class LogWrapper {

    private static Pattern patternPan = Pattern.compile("^(\\d{4})(\\d{4,10})(\\d{4})$");

    public static String wrapPan(String pan) {
        Matcher matcherPan = patternPan.matcher(pan);
        if (!matcherPan.find()) {
            log.error(String.format("PAN %s не прошёл вадидацию и не может быть замаскирован", pan), new RegExpFormatException());
        }
        return pan.replaceAll(matcherPan.group(2), String.join("", Collections.nCopies(matcherPan.group(2).length(), "*")));
    }

}
