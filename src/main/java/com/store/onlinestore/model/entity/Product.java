package com.store.onlinestore.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "productEntity")
@Table(name = "product_tbl")

public class Product extends Base {
    @Id
    @SequenceGenerator(name = "productSeq", sequenceName = "product_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productSeq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 60)
//    @Pattern(regexp = "^[a-zA-Z\\s\\d]{3,60}$", message = "Invalid Name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "is_active")
    private boolean status;

    @Column(name = "brand")
//    @Pattern(regexp = "^[a-zA-Z\\s\\d]{3,60}$", message = "Invalid Brand")
    private String brand;

    @OneToOne
    @JoinColumn(name = "unit_id")
    private ProductUnit unit;

    @ManyToOne
    @JoinColumn(name = "product_group_id")
    private ProductGroup productGroup;

    @Column(name = "date_of_modified")
    private LocalDateTime dateOfModified;

    @PrePersist
    public void beforeDateModified(){
        dateOfModified = LocalDateTime.now();
    }

    @Column(name = "barcode", unique = true)
//    @Pattern(regexp = "^\\d{3,30}$", message = "Invalid Barcode")
    private String barcode;



}
