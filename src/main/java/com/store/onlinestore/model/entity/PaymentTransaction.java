package com.store.onlinestore.model.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
@Entity(name="paymentTransaction")
@Table(name = "payment_transaction_tbl")
// todo : javase polymorphism
// todo : transaction dateTime
public class PaymentTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @OneToMany
    private List<CashPayment> cashPaymentList;

    @OneToMany
    private List<CardPayment> cardPaymentList;

    @OneToMany
    private List<CheckPayment> checkPaymentList;

}
