package com.store.onlinestore.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder

@Entity(name = "inventoryEntity")
@Table(name = "inventory_tbl")

public class Inventory extends Base {

    @Id
    @SequenceGenerator(name = "inventorySeq", sequenceName = "inventory_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventorySeq")
    private int id;

    @Column(name = "count")
    private int count;

    @Column(name = "location",length = 100)
    private String location;

    @OneToOne
    @JoinTable(name = "inventory_product_tbl")
    private Product product;

    @Column(name = "description",length = 100)
    private String description;
}
