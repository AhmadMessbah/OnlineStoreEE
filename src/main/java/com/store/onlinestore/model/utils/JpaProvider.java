package com.store.onlinestore.model.utils;

import lombok.Getter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaProvider {
    @Getter
    private static JpaProvider jpa = new JpaProvider();
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("store");

    private JpaProvider() {
    }

    public EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
}
