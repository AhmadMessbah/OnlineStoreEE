package com.store.onlinestore.controller.exception;

public class CardPaymentNotFoundException extends Exception {
    public CardPaymentNotFoundException() {
        super("Card Not Found !!!");
    }
}
