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

@Entity(name = "inventory_transaction")
@Table(name = "inventory_transaction_tbl")
@NamedQueries({
        @NamedQuery(name = "TransactionInventory.FindByDeliverPerson", query = "select p from personEntity p where p.name like :name and p.family like :family"),
        @NamedQuery(name = "TransactionInventory.FindByPhoneNumber", query = "select p from personEntity  p where p.phoneNumber=:phoneNumber")
})
public class InventoryTransaction extends Base{
    @Id
    @SequenceGenerator(name = "inventoryTransactionSeq", sequenceName = "inventory_transaction_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventoryTransactionSeq")
    private Long id;

    @Column(name = "registerDateTime")
    private LocalDateTime registerDateTime;

    @Column(name = "transaction_type")
    private String transactionType;

    @OneToOne
    @JoinTable(name = "inventory_transaction_product_tbl")
    private Product product;

    @ManyToOne
    private Manager deliveryPerson;

    @ManyToOne
    private Customer receiverPerson;
}
