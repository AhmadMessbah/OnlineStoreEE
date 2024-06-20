package com.store.onlinestore.controller.exception;

public class InventoryNotFoundException extends Exception{
    public InventoryNotFoundException() {

        super("Inventory Not Found !!!");
    }
}
