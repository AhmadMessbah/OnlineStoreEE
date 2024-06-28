package com.store.onlinestore.model.entity;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Base {
    public boolean deleted;
}
