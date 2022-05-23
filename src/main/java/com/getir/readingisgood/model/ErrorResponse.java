package com.getir.readingisgood.model;

/**
 * The type Error response. @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com @Version
 * 1.0
 */
public class ErrorResponse {
  private int code;
  private String message;

  /**
   * Instantiates a new Error response.
   *
   * @param code the code
   * @param messages the messages
   */
  public ErrorResponse(int code, String messages) {
    this.code = code;
    this.message = messages;
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
   * Sets code.
   *
   * @param code the code
   */
  public void setCode(int code) {
    this.code = code;
  }

  /**
   * Gets message.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Sets message.
   *
   * @param message the message
   */
  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "ErrorResponse{" + "code=" + code + ", message='" + message + '\'' + '}';
  }
}
