package com.store.onlinestore.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "productEntity")
@Table(name = "product_tbl")
@NamedQueries({
        @NamedQuery(name = "Product.FindByNameAndBrand", query = "select p from productEntity p where p.name like :name and p.brand like :brand"),
        @NamedQuery(name = "Product.FindByBarcode", query = "select p from productEntity p where p.barcode =:barcode"),
        @NamedQuery(name = "Product.FindByBrand", query = "select p from productEntity p where p.brand like :brand")
})
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

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "unit_id")
    private ProductUnit unitId;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "product_group_id")
    private ProductGroup productGroupId;

//    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    private List<Attachment> attachmentList;

    @Column(name = "date_of_modified")
    private LocalDateTime dateOfModified;
//    @PrePersist


    @Column(name = "barcode", unique = true)
//    @Pattern(regexp = "^\\d{3,30}$", message = "Invalid Barcode")
    private String barcode;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "inventory_id")
    private Inventory inventoryId;
}
