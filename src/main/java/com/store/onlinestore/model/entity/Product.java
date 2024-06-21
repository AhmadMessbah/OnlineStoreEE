package com.store.onlinestore.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString
@Entity(name = "productEntity")
@Table(name = "product_tbl")
@NamedQueries({
        @NamedQuery(name = "Product.FindByNameAndBrand", query = "select p from productEntity p where p.name like :name and p.brand like :brand"),
        @NamedQuery(name = "Product.FindByBarcode", query = "select p from productEntity p where p.barcode =:barcode"),
        @NamedQuery(name = "Product.FindByBrand", query = "select p from productEntity p where p.brand like :brand")
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 60)
    @Pattern(regexp = "^[a-zA-Z\\s]{3,60}$", message = "Invalid Name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "is_active")
    private boolean status;

    @Column(name = "brand")
    private String brand;

    @OneToOne
    @JoinColumn(name = "unit_id")
    private ProductUnit unitId;

    @ManyToOne
    @JoinColumn(name = "product_group_id")
    private ProductGroup productGroupId;

    @Column(name = "price")
    private Integer price;

//    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    private List<Attachment> attachmentList;

    @Column(name = "date_of_modified")
    private Date dateOfModified;

    @Column(name = "barcode", unique = true)
    private String barcode;


    @ManyToOne
    private Inventory inventory;
}
