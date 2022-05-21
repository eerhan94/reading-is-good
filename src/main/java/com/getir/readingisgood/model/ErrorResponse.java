package com.getir.readingisgood.model;

/**
 * @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com
 * @Version 1.0
 */
public class ErrorResponse {
    private int code;
    private String message;

    public ErrorResponse(int code, String messages) {
        this.code = code;
        this.message = messages;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
