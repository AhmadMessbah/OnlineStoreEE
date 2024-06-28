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
public abstract class Payment extends Base {

    @Column(name = "payment_price")
    private float price;

    @Column(name="payment_date")
    private LocalDateTime paymentDateTime;

    @Column(name="description")
    private String description;
}
