package com.store.onlinestore.model.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.Pattern;
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
@NamedQueries({
        @NamedQuery(name = "Inventory.FindByProductId", query = "select p from inventoryEntity p where p.product.id=:productId "),
        @NamedQuery(name = "Inventory.FindByInventoryName", query = "select p from inventoryEntity p where p.name like :name")
})
public class Inventory extends Base {

    @Id
    @SequenceGenerator(name = "inventorySeq", sequenceName = "inventory_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventorySeq")
    private int id;

    @Column(name = "name")
//    @Pattern(regexp = "^[a-zA-Z\\s]{3,40}$", message = "Invalid Inventory Name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "count")
    private int count;

    @Column(name = "location")
    private String loction;

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
