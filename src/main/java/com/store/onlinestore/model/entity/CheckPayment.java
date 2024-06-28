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
        @NamedQuery(name = "Check.FindByDateTime", query = "select ch from checkEntity ch where ch.dateTime = dateTime")
})

public class CheckPayment extends Payment {

    @ManyToOne
    private Customer customer;

    @Column(name = "check_number", length = 20, unique = true)
    private Long checkNumber;

    @Column(name = "date_time")
    private LocalDateTime dateTime;
}
