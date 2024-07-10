
package com.store.onlinestore.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "cashEntity")
@Table(name = "cash_tbl")

@NamedQueries({
        @NamedQuery(name = "Cash.FindByDateTime", query = "select c from cashEntity c where c.paymentDateTime = paymentDateTime"),
        @NamedQuery(name = "Cash.FindById", query = "select c from cashEntity c where c.id = id"),

})

public class CashPayment extends Payment {
    @Id
    @SequenceGenerator(name = "paymentSeq", sequenceName = "payment_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paymentSeq")
    @Column(name = "id")
    private Long id;

    @ManyToOne
    private PaymentTransaction paymentTransaction;
}
