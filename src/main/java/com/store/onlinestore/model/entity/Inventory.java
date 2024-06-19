package com.store.onlinestore.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Statement;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder

@Entity(name = "inventory")
@Table(name = "inaventory_tbl")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "inventoryName")
    private String name;

    @Column(name = "productCount")
    private int count;

    @OneToMany
    private List<Product> product;

}
