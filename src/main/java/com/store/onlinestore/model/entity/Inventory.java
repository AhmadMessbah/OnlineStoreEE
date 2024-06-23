package com.store.onlinestore.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
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
@Table(name = "inventory_tbl")
@NamedQueries({
        // TODO: 6/20/2024 check product list 
//        @NamedQuery(name = "Inventory.FindByproduct", query = "select p from inventoryEntity p where p.productList like :product "),
        @NamedQuery(name = "findByInventoryName", query = "select p from inventoryEntity p where p.InventoryName like :name")
})
public class Inventory {

    @Id
    @SequenceGenerator(name = "inventorySeq", sequenceName = "inventory_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventorySeq")
    private int id;

    @Column(name = "inventoryName")
    @Pattern(regexp = "^[a-zA-Z\\s]{3,40}$", message = "Invalid Inventory Name")
    private String InventoryName;

    @Column(name = "productStock")
    private int productStock;

    @Column(name = "totalStock")
    private int totalStock;

    @Column(name = "registerProductDate")
    private LocalDateTime registerDate;

    @OneToMany   // todo : OneToOne
    @JoinTable(name = "inventory_product_tbl")
    private List<Product> productList;

    @OneToMany
    @JoinTable(name = "inventory_supplier_tbl")
    private List<Supplier> supplierList;

    public void addProduct(Product product) {
        if (productList == null) {
            productList = new ArrayList<>();
        }
        productList.add(product);
    }

    public void addSupplier(Supplier supplier) {
        if (supplierList == null) {
            supplierList = new ArrayList<>();
        }
        supplierList.add(supplier);
    }

}
