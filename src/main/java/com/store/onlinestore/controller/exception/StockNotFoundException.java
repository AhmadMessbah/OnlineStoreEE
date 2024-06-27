package com.store.onlinestore.controller.exception;

public class StockNotFoundException extends Exception{
    public StockNotFoundException() {
        super("Stock Not Found !!!");
    }
}
