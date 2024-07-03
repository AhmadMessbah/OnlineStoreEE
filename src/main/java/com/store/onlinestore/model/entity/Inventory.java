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
        @NamedQuery(name = "findByProductId", query = "select p from productEntity p where p.id=:id "),
        @NamedQuery(name = "findByInventoryName", query = "select p from productEntity p where p.name like :name")
})
public class Inventory extends Base {

    @Id
    @SequenceGenerator(name = "inventorySeq", sequenceName = "inventory_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventorySeq")
    private int id;

    @Column(name = "inventoryDescription")
    private String description;

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
