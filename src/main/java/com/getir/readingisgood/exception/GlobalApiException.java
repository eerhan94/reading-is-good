package com.getir.readingisgood.exception;

/**
 * @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com
 * @Version 1.0
 */
public class GlobalApiException extends RuntimeException {

    private final int code;
    private final String message;

    public GlobalApiException(ErrorCodes errorCode) {
        super();
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}