package com.store.onlinestore.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.naming.Name;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder

@Entity(name = "inventoryEntity")
@Table(name = "inaventory_tbl")
@NamedQueries({
        // TODO: 6/20/2024 check product list 
//        @NamedQuery(name = "Inventory.FindByproduct", query = "select p from inventoryEntity p where p.productList like :product "),
        @NamedQuery(name = "Inventory.FindByName" , query = "select p from inventoryEntity p where p.name like :name")
})
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "inventoryName")
    private String name;

    @Column(name = "productCount")
    private int count;

    @Column(name = "registerProductDate")
    private LocalDateTime registerDate;

    @OneToMany
    private List<Product> productList;

    @OneToMany
    private List<Supplier> supplierList;

    public void addProduct(Product product){
        if (productList == null){
            productList = new ArrayList<>();
        }
        productList.add(product);
    }
    public void addSupplier(Supplier supplier){
        if (supplierList == null){
            supplierList = new ArrayList<>();
        }
        supplierList.add(supplier);
    }

}
