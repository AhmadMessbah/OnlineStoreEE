package com.store.onlinestore.model.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
@Entity
@Table(name = "payment_transactions")
public class PaymentTransaction <T extends Payment> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "payment")
    private T payment;
}
