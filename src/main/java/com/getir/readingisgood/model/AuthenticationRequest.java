package com.getir.readingisgood.model;

/**
 * The type Authentication request. @Author Eyup Erhan KARAASLAN -
 * eyuperhankaraaslan94@gmail.com @Version 1.0
 */
public class AuthenticationRequest {
  private String username;
  private String password;

  /**
   * Gets username.
   *
   * @return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * Sets username.
   *
   * @param username the username
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Gets password.
   *
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets password.
   *
   * @param password the password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "AuthenticationRequest{"
        + "username='"
        + username
        + '\''
        + ", password='"
        + password
        + '\''
        + '}';
  }
}
