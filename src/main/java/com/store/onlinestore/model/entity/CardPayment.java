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

@Entity(name = "cardEntity")
@Table(name = "card_tbl")

@NamedQueries({
        @NamedQuery(name = "Card.FindByCardNumber", query = "select c from cardEntity  c where c.cardNumber =cardNumber"),
        @NamedQuery(name = "Card.FindByDateTime", query = "select c from checkEntity c where c.paymentDateTime = paymentDateTime"),
        @NamedQuery(name = "Card.FindById", query = "select c from checkEntity c where c.id = id")
})

public class CardPayment extends Payment {
    @Id
    @SequenceGenerator(name = "paymentSeq", sequenceName = "payment_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paymentSeq")
    @Column(name = "id")
    private Long id;

    @ManyToOne
    private Customer customer;

    @Column(name = "card_number" ,length = 20, unique = true)
    private Long cardNumber;
}


