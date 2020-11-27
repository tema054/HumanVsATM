package ru.sber.projectATM.core.bank.ATM.exception;

public class FrontSystemNotAvailable extends Exception {
    public FrontSystemNotAvailable() {
    }

    public FrontSystemNotAvailable(String message) {
        super(message);
    }

    public FrontSystemNotAvailable(String message, Throwable cause) {
        super(message, cause);
    }

    public FrontSystemNotAvailable(Throwable cause) {
        super(cause);
    }

    public FrontSystemNotAvailable(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
