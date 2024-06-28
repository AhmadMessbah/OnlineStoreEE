package com.store.onlinestore.model.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.sql.exec.spi.StandardEntityInstanceResolver;


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
        @NamedQuery(name = "findByProductId", query = "select p from inventoryEntity p where p.product.id=:productId "),
        @NamedQuery(name = "findByInventoryName", query = "select p from inventoryEntity p where p.InventoryName like :name"),
        @NamedQuery(name = "findByInventoryNumber", query = "select p from inventoryEntity p where p.inventoryNumber=:inventoryNumber")
})
public class Inventory extends Base {

    @Id
    @SequenceGenerator(name = "inventorySeq", sequenceName = "inventory_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventorySeq")
    private int id;

    @Column(name = "inventoryName")
//    @Pattern(regexp = "^[a-zA-Z\\s]{3,40}$", message = "Invalid Inventory Name")
    private String InventoryName;

    @Column(name = "inventoryDescription")
    private String description;

    @Column(name = "inventoryNumber")
//    @Pattern(regexp = "^//d")
    private String inventoryNumber;

    @Column(name = "inventoryType")
    private String inventoryType;

    @Column(name = "productStock")
    private int productStock;

    @OneToOne
    @JoinTable(name = "inventory_product_tbl")
    private Product product;

    @OneToMany
    @JoinTable(name = "inventory_supplier_tbl")
    private List<Supplier> supplierList;


    public void addSupplier(Supplier supplier) {
        if (supplierList == null) {
            supplierList = new ArrayList<>();
        }
        supplierList.add(supplier);
    }

}
