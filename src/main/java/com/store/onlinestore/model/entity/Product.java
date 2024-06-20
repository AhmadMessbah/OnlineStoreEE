package com.store.onlinestore.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

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
    @Column(name = "unit_id")
    @OneToOne
    private ProductUnit unitId;
    @Column(name = "product_group_id")
    @ManyToOne
    private ProductGroup productGroupId;
    @Column(name = "price")
    private Integer price;
    @Column(name = "image", length = 50)
    private String image;
    @Column(name = "date_of_modified")
    private Date dateOfModified;
    @Column(name = "barcode",unique = true)
    private String barcode;
    @Column(name = "in_stock")
    private Integer inStock;

    @ManyToOne
    private Inventory inventory;
}
