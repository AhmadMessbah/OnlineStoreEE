package com.store.onlinestore.model.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.time.LocalDateTime;
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder

@MappedSuperclass
public abstract class Payment {
    @Id
    @SequenceGenerator(name = "paymentSeq", sequenceName = "payment_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paymentSeq")
    @Column(name = "id")
    private Long id;

    @Column(name = "payment_price")
    private float price;

    @Column(name="payment_date")
    private LocalDateTime dateOfPayment;

    @Column(name="description")
    private String description;
}
