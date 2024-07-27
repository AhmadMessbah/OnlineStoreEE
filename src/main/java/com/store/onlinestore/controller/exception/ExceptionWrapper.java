package com.store.onlinestore.controller.exception;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.OptimisticLockException;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ExceptionWrapper {
    public static Map<Integer, String> getMessage(Exception e) {
        Map<Integer, String> error = new HashMap<>();
        if (e instanceof NullPointerException) {
            error.put(400, "NullPointerException");
        } else if (e instanceof SQLException) {
            error.put(500, "خطا در دیتایس");
        } else if (e instanceof OptimisticLockException) {
            error.put(500, "خطای همزمانی تغییرات بر روی یک رکورد");
        }else if(
            e instanceof AdminNotFoundException ||
            e instanceof ProductNotFoundException
        ){
            error.put(204,e.getMessage());
        } else {
            error.put(500,"خطای ناشناخته - با ادمین تماس بگیرید");
        }
        return error;
    }
}
