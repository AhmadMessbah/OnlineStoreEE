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

@Entity(name = "checkEntity")
@Table(name = "check_tbl")

public class CheckPayment extends Payment {
    @Id
    @SequenceGenerator(name = "paymentSeq", sequenceName = "payment_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paymentSeq")
    @Column(name = "id")
    private Long id;

    @Column(name = "check_number", length = 20, unique = true)
    private Long checkNumber;

    @ManyToOne
    private PaymentTransaction paymentTransaction;
}
