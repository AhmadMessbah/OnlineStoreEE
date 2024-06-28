
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

@Entity(name = "cashEntity")
@Table(name = "cash_tbl")

@NamedQueries({
        @NamedQuery(name = "Cash.FindByDateTime", query = "select c from checkEntity c where c.dateTime = dateTime")
})

public class CashPayment extends Payment {

    @ManyToOne
    private Customer customer;

    @Column(name = "date_time")
    private LocalDateTime localDateTime;
}
