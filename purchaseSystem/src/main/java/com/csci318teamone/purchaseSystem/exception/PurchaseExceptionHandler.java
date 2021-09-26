package com.csci318teamone.purchaseSystem.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PurchaseExceptionHandler {

  @ExceptionHandler(value = { PurchaseNotFoundException.class })
  public ResponseEntity<Object> handlePurchaseNotFoundException(
    PurchaseNotFoundException e
  ) {
    HttpStatus notFound = HttpStatus.NOT_FOUND;
    PurchaseException purchaseException = new PurchaseException(
      e.getMessage(),
      notFound,
      ZonedDateTime.now(ZoneId.of("Z"))
    );
    return new ResponseEntity<>(purchaseException, notFound);
  }
}
