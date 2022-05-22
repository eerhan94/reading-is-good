package com.getir.readingisgood.controller;

import com.getir.readingisgood.configuration.JwtUtil;
import com.getir.readingisgood.model.AuthenticationRequest;
import com.getir.readingisgood.model.AuthenticationResponse;
import com.getir.readingisgood.service.CustomUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Authentication controller. @Author Eyup Erhan KARAASLAN -
 * eyuperhankaraaslan94@gmail.com @Version 1.0
 */
@RestController
@RequestMapping(path = "/authenticate")
public class AuthenticationController {
  /** The Logger. */
  Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

  private final JwtUtil jwtUtil;
  private final AuthenticationManager authenticationManager;
  private final CustomUserDetailsService userDetailsService;

  /**
   * Instantiates a new Authentication controller.
   *
   * @param jwtUtil the jwt util
   * @param authenticationManager the authentication manager
   * @param userDetailsService the user details service
   */
  public AuthenticationController(
      JwtUtil jwtUtil,
      AuthenticationManager authenticationManager,
      CustomUserDetailsService userDetailsService) {
    this.jwtUtil = jwtUtil;
    this.authenticationManager = authenticationManager;
    this.userDetailsService = userDetailsService;
  }

  /**
   * Crete token response entity.
   *
   * @param authRequest the auth request
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<AuthenticationResponse> creteToken(
      @RequestBody AuthenticationRequest authRequest) {
    logger.info("AuthenticationRequest -> Username: {}", authRequest.getUsername());
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            authRequest.getUsername(), authRequest.getPassword()));
    UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
    return ResponseEntity.ok(new AuthenticationResponse(jwtUtil.generateToken(userDetails)));
  }
}
