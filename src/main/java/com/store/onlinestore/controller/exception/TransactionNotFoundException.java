package com.store.onlinestore.controller.exception;

public class TransactionNotFoundException extends Exception{
    public TransactionNotFoundException() {

        super("Transaction Not Found !!!");
    }
}
