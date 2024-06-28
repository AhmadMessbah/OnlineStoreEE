
package com.store.onlinestore.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@Entity(name = "cashEntity")
@Table(name = "cash_tbl")

@NamedQueries({
        @NamedQuery(name = "Cash.FindByDateTime", query = "select c from checkEntity c where c.dateOfPayment = dateOfPayment")
})

public class CashPayment extends Payment {
    @Id
    @SequenceGenerator(name = "paymentSeq", sequenceName = "payment_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paymentSeq")
    @Column(name = "id")
    private Long id;

    @ManyToOne
    private Customer customer;
}
