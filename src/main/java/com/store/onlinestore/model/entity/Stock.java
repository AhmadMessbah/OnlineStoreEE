package com.store.onlinestore.model.entity;

import jakarta.persistence.*;
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

@Entity(name = "stockEntity")
@Table(name = "stock_tbl")
@NamedQueries({
        @NamedQuery(name = "FindByStockType", query = "select p from stockEntity p where p.stockType=:stockType"),
        @NamedQuery(name = "FindByStockItems", query = "select p from stockEntity p where p.stockItems=:stockItems")
})
public class Stock {
    @Id
    @SequenceGenerator(name = "stockSeq", sequenceName = "stock_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stockSeq")
    private Long id;

    @Column(name = "stockDescription")
    private String stockDescription;

    @Column(name = "stockType")
    private String stockType;

    @Column(name = "stockItems")
    private String stockItems;

    @Column(name = "stockNumber")
    //    @Pattern(regexp = "^//d")
    private int stockNumber;


    @OneToMany
    @JoinTable(name = "stock_inventory_tbl")
    private List<Inventory> inventoryList;

    public void addInventory(Inventory inventory) {
        if (inventoryList == null) {
            inventoryList = new ArrayList<>();
        }
        inventoryList.add(inventory);
    }
}
