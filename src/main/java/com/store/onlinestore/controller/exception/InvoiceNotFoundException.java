package com.store.onlinestore.controller.exception;

public class InvoiceNotFoundException extends Exception{
    public InvoiceNotFoundException() {

        super("Invoice Not Found !!!");
    }
}
