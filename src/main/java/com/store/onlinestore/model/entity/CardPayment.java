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
@Entity(name = "cardEntity")
@Table(name = "card_tbl")
@NamedQueries({
        @NamedQuery(name = "Card.FindByCardNumber", query = "select c from cardEntity  c where c.cardNumber =cardNumber")
})
public class CardPayment extends Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "cardNumber" ,unique = true)
    private long cardNumber;
    @Column(name = "cvv2")
    private int cvv2;

    @Column(name = "card_expire_date")
    private LocalDateTime cardExpireDate;
}


