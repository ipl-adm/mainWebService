package com.indieplay.mainWebService.exception;

public class IPException extends RuntimeException {
    public IPException() {
    }

    public IPException(String message) {
        super(message);
    }

    public IPException(String message, Throwable cause) {
        super(message, cause);
    }

    public IPException(Throwable cause) {
        super(cause);
    }

    public IPException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
