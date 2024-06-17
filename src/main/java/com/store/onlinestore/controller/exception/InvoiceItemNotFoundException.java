package com.store.onlinestore.controller.exception;

public class InvoiceItemNotFoundException extends Exception {
    public InvoiceItemNotFoundException(){
        super("Invoice item Not Found !!!");
    }
}
