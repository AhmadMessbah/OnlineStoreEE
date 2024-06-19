package com.store.onlinestore.model.entity;
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
    private float price;
    private int discount;
    private float pureAmount;
    private LocalDateTime dateOfPayment;

}
