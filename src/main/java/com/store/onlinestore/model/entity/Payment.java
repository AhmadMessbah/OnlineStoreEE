package com.store.onlinestore.model.entity;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
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
    @ManyToOne
    private Customer customer;

    @Column(name = "price")
    private float price;

    @Column(name="payment_date")
    private LocalDateTime dateOfPayment;

    @Column(name="description")
    private String description;
}
