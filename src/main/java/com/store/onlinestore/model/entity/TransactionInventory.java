package com.store.onlinestore.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder

@Entity(name = "transaction")
@Table(name = "transaction_tbl")
@NamedQueries({
        @NamedQuery(name = "TransactionInventory.FindByDeliverPerson", query = "select p from personEntity p where p.name like :name and p.family like :family"),
        @NamedQuery(name = "TransactionInventory.FindByPhoneNumber", query = "select p from personEntity  p where p.phoneNumber=:phoneNumber")
})
public class TransactionInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "registerDateTime")
    private LocalDateTime registerDateTime;

    @OneToOne
    private ProductUnit unit;

    @OneToOne
    private ProductGroup group;

    @OneToMany
    private List<Product> productList;

    @OneToOne
    private Person deliveryPerson;

    @OneToOne
    private Person receiverPerson;

    public void addProduct(Product product){
        if (productList == null){
            productList = new ArrayList<>();
        }
        productList.add(product);
    }
}
