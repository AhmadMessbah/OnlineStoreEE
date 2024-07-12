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

@Entity(name = "cardEntity")
@Table(name = "card_tbl")

public class CardPayment extends Payment {
    @Id
    @SequenceGenerator(name = "paymentSeq", sequenceName = "payment_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paymentSeq")
    @Column(name = "id")
    private Long id;

    @Column(name="bank_name")
    private  String bankName;

    @Column(name = "card_number" ,length = 20, unique = true)
    private Long cardNumber;

    @ManyToOne
    @JoinColumn(name="transaction_id")
    private PaymentTransaction paymentTransaction;
}


