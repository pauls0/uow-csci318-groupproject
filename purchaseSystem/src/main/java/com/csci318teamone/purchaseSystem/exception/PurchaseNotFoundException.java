package com.csci318teamone.purchaseSystem.exception;

public class PurchaseNotFoundException extends RuntimeException {

  public PurchaseNotFoundException(String message) {
    super(message);
  }

  public PurchaseNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
