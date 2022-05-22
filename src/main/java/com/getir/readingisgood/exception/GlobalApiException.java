package com.getir.readingisgood.exception;

/**
 * The type Global api exception. @Author Eyup Erhan KARAASLAN -
 * eyuperhankaraaslan94@gmail.com @Version 1.0
 */
public class GlobalApiException extends RuntimeException {

  private final int code;
  private final String message;

  /**
   * Instantiates a new Global api exception.
   *
   * @param errorCode the error code
   */
  public GlobalApiException(ErrorCodes errorCode) {
    super();
    this.code = errorCode.getCode();
    this.message = errorCode.getMessage();
  }

  /**
   * Gets code.
   *
   * @return the code
   */
  public int getCode() {
    return code;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
