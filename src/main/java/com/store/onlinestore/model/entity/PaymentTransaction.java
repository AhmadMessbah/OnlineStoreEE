package com.store.onlinestore.model.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
@Entity(name="paymentTransactionEntity")
@Table(name = "payment_transaction_tbl")
public class PaymentTransaction extends Base {
    @Id
    @SequenceGenerator(name = "paymentTransactionSeq", sequenceName = "payment_transaction_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paymentTransactionSeq")
    @Column(name = "id")
    private int id;

    @ManyToOne
    private Customer customer;

//    todo : relation not saved
    @OneToMany(mappedBy = "paymentTransaction")
//    @JoinTable(name = "payment_transaction_cash")
    private List<CashPayment> cashPaymentList;

    @OneToMany(mappedBy = "paymentTransaction")
//    @JoinTable(name = "payment_transaction_card")
    private List<CardPayment> cardPaymentList;

    @OneToMany(mappedBy = "paymentTransaction")
//    @JoinTable(name = "payment_transaction_check")
    private List<CheckPayment> checkPaymentList;

    public void addCashPayment(CashPayment cashPayment) {
        if (cashPaymentList == null) {
            cashPaymentList = new ArrayList<>();
        }
        cashPaymentList.add(cashPayment);
    }

    public void addCardPayment(CardPayment cardPayment) {
        if (cardPaymentList == null) {
            cardPaymentList = new ArrayList<>();
        }
        cardPaymentList.add(cardPayment);
    }

    public void addCheckPayment(CheckPayment checkPayment) {
        if (checkPaymentList == null) {
            checkPaymentList = new ArrayList<>();
        }
        checkPaymentList.add(checkPayment);
    }
}
