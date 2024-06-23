package com.store.onlinestore.controller.exception;

public class CustomerNotFoundException extends Exception{
    public CustomerNotFoundException(){
        super("Customer Not Found !!!");
    }
}
