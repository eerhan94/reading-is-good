package com.getir.readingisgood.exception;

import com.getir.readingisgood.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.getir.readingisgood.exception.ErrorCodes.BAD_CREDENTIALS_EXCEPTION;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public final ResponseEntity<Exception> handleException(
            Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex);
    }

    @ExceptionHandler(value = BadCredentialsException.class)
    public final ResponseEntity<ErrorResponse> handleBadCredentialsException(
            Exception ex) {
        return ResponseEntity.ok(new ErrorResponse(BAD_CREDENTIALS_EXCEPTION.getCode(), BAD_CREDENTIALS_EXCEPTION.getMessage()));
    }

    @ExceptionHandler(value = GlobalApiException.class)
    public ResponseEntity<ErrorResponse> handleInvalidLinkException(GlobalApiException ex) {
        return ResponseEntity.ok(new ErrorResponse(ex.getCode(), ex.getMessage()));
    }
}