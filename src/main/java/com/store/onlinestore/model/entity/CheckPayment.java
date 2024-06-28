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

@Entity(name = "checkEntity")
@Table(name = "check_tbl")

@NamedQueries({
        @NamedQuery(name = "Check.FindByCheckNumber", query = "select ch from checkEntity ch where ch.checkNumber = checkNumber"),
        @NamedQuery(name = "Check.FindByDateTime", query = "select ch from checkEntity ch where ch.dateOfPayment = dateOfPayment")
})

public class CheckPayment extends Payment {
    @Id
    @SequenceGenerator(name = "paymentSeq", sequenceName = "payment_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paymentSeq")
    @Column(name = "id")
    private Long id;

    @ManyToOne
    private Customer customer;

    @Column(name = "check_number", length = 20, unique = true)
    private Long checkNumber;
}
