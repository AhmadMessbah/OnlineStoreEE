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
        @NamedQuery(name = "Cash.FindById", query = "select c from checkEntity c where c.id = id"),
})

public class Cash extends Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "cash_tendered")
    private float cashTendered;

    @Column(name = "date")
    private LocalDateTime localDateTime;
}
