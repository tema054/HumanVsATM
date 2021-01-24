package ru.sber.projectATM.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//често украденный класс
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class FrontSystemNotAvailable extends RuntimeException {
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
