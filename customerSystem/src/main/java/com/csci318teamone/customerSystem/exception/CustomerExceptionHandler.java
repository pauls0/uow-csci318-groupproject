package com.csci318teamone.customerSystem.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler {

  @ExceptionHandler(value = { CustomerNotFoundException.class })
  public ResponseEntity<Object> handleCustomerNotFoundException(
    CustomerNotFoundException e
  ) {
    HttpStatus notFound = HttpStatus.NOT_FOUND;
    CustomerException customerException = new CustomerException(
      e.getMessage(),
      notFound,
      ZonedDateTime.now(ZoneId.of("Z"))
    );
    return new ResponseEntity<>(customerException, notFound);
  }
}
