package ru.sber.projectATM.core.subFunction.exceptoin;


public class RegExpFormatException extends Exception {
    public RegExpFormatException() {
    }

    public RegExpFormatException(String message) {
        super(message);
    }

    public RegExpFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegExpFormatException(Throwable cause) {
        super(cause);
    }

    public RegExpFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
