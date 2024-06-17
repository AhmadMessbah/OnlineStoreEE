package com.store.onlinestore.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@Entity(name="invoiceItemEntity")
@Table(name="invoice_item_tbl")
public class InvoiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @ManyToOne
//    private Product product;

    @Column(name = "count")
    private int count;

    @Column(name = "price")
    private int price;
}
