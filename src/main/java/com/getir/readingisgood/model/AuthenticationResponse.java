package com.getir.readingisgood.model;

/**
 * The type Authentication response. @Author Eyup Erhan KARAASLAN -
 * eyuperhankaraaslan94@gmail.com @Version 1.0
 */
public class AuthenticationResponse {
  private final String token;

  /**
   * Instantiates a new Authentication response.
   *
   * @param token the token
   */
  public AuthenticationResponse(String token) {
    this.token = token;
  }

  /**
   * Gets token.
   *
   * @return the token
   */
  public String getToken() {
    return token;
  }
}
