package com.csci318teamone.productSystem.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionHandler {

  @ExceptionHandler(value = { ProductNotFoundException.class })
  public ResponseEntity<Object> handleProductNotFoundException(
    ProductNotFoundException e
  ) {
    HttpStatus notFound = HttpStatus.NOT_FOUND;
    ProductException productException = new ProductException(
      e.getMessage(),
      notFound,
      ZonedDateTime.now(ZoneId.of("Z"))
    );
    return new ResponseEntity<>(productException, notFound);
  }
}
