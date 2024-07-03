package com.store.onlinestore.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@SuperBuilder

@Entity(name = "inventoryTransactionEntity")
@Table(name = "inventory_transaction_tbl")
@NamedQueries({
        @NamedQuery(name = "FindByDeliverPerson", query = "select d from inventoryTransactionEntity d where d.deliveryPerson.name like :name and d.deliveryPerson.family like :family"),
        @NamedQuery(name = "FindByReceiverPerson", query = "select r from inventoryTransactionEntity r where r.receiverPerson.name like :name and r.receiverPerson.family like :family"),
        @NamedQuery(name = "FindByRegisterDateTime" , query = "select oo from inventoryTransactionEntity oo where oo.registerDateTime=:registerDateTime"),
        @NamedQuery(name = "findByProductId" , query = "select oo from inventoryTransactionEntity oo where oo.productId.id=:productId")
})
public class InventoryTransaction extends Base {
    @Id
    @SequenceGenerator(name = "inventoryTransactionSeq", sequenceName = "inventory_transaction_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventoryTransactionSeq")
    private Long id;

    @Column(name = "registerDateTime")
    private LocalDateTime registerDateTime;

    @OneToOne
    @JoinTable(name = "inventory_transaction_product_tbl")
    private Product productId;

    @ManyToOne
    private Manager deliveryPerson;

    @ManyToOne
    private Customer receiverPerson;

    @PrePersist
    protected void beforeInsert() {
        registerDateTime = LocalDateTime.now();
    }
}
