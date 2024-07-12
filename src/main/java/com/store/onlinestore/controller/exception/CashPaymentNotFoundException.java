package com.store.onlinestore.controller.exception;

public class CashPaymentNotFoundException extends Exception {
    public CashPaymentNotFoundException() {
        super("Cash Payment Not Found !!!");
    }
}
