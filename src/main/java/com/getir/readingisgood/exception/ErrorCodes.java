package com.getir.readingisgood.exception;

/**
 * The enum Error codes. @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com @Version 1.0
 */
public enum ErrorCodes {

  /** The Customer not found. */
CUSTOMER_NOT_FOUND(2001, "Customer not found"),
  /** The Order not found. */
ORDER_NOT_FOUND(2002, "Order not found"),
  /** The Book not found. */
BOOK_NOT_FOUND(2003, "Book not found"),
  /** The Books not enough. */
BOOKS_NOT_ENOUGH(2004, "Books are not enough "),
  /** The User not found. */
USER_NOT_FOUND(2005, "User not found "),
  /** The Bad credentıals exceptıon. */
BAD_CREDENTIALS_EXCEPTION(2006, "Incorrect username or password"),
  /** The Emaıl already usıng. */
EMAIL_ALREADY_USING(2007, "Email address already using"),
  /** The Phone already usıng. */
PHONE_ALREADY_USING(2008, "Phone number already using"),
  /** The Book name already exıst. */
BOOK_NAME_ALREADY_EXIST(2009, "Book name already exist");

  private int code;
  private String message;

  ErrorCodes(int code, String message) {
    this.code = code;
    this.message = message;
  }

  /**
   * Gets code.
   *
   * @return the code
   */
public int getCode() {
    return code;
  }

  /**
   * Gets message.
   *
   * @return the message
   */
public String getMessage() {
    return message;
  }
}
