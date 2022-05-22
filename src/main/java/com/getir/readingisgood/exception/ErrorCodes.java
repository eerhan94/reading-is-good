package com.getir.readingisgood.exception;

/**
 * @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com
 * @Version 1.0
 */
public enum ErrorCodes {

    CUSTOMER_NOT_FOUND(2001, "Customer not found"),
    ORDER_NOT_FOUND(2002, "Order not found"),
    BOOK_NOT_FOUND(2003, "Book not found"),
    BOOKS_NOT_ENOUGH(2004, "Books are not enough "),
    USER_NOT_FOUND(2005, "User not found "),
    BAD_CREDENTIALS_EXCEPTION(2006, "Incorrect username or password"),
    EMAIL_ALREADY_USING(2007, "Email address already using"),
    PHONE_ALREADY_USING(2008, "Phone number already using"),
    BOOK_NAME_ALREADY_EXIST(2009, "Book name already exist");

    private int code;
    private String message;

    ErrorCodes(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}