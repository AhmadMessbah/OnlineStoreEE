package com.store.onlinestore.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder

@Entity(name = "supplierEntity")
@Table(name = "supplier_tbl")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "supplierName")
    private String name;

    @Column(name = "supplierFamily")
    private String family;

    @Column(name = "mobile")
    private String mobilePhone;

    @Column(name = "nationalCode" , length = 10)
    private String nationalCode;

    @Column(name = "company")
    private String company;
}
