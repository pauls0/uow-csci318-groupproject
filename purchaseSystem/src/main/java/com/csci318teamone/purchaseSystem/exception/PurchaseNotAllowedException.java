package com.csci318teamone.purchaseSystem.exception;

public class PurchaseNotAllowedException extends RuntimeException {

  public PurchaseNotAllowedException(String message) {
    super(message);
  }

  public PurchaseNotAllowedException(String message, Throwable cause) {
    super(message, cause);
  }
}
