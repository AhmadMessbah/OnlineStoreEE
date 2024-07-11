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
