package com.store.onlinestore.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
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
        @NamedQuery(name = "Check.FindById", query = "select ch from checkEntity ch where ch.id = id"),
        @NamedQuery(name = "Check.FindByNameAndFamily", query = "select ch from checkEntity ch where ch.name like : name and ch.family like : family")
})

public class Check extends Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name", length = 30)
    @Pattern(regexp = "^[a-zA-Z\\s]{2,30}$", message = "Invalid Name")
    private String name;

    @Column(name = "family", length = 30)
    @Pattern(regexp = "^[a-zA-Z\\s]{2,30}$", message = "Invalid Family")
    private String family;

    @Column(name = "name_pay_to", length = 30)
    @Pattern(regexp = "^[a-zA-Z\\s]{2,30}$", message = "Invalid Name")
    private String namePayTo;

    @Column(name = "family_pay_to", length = 30)
    @Pattern(regexp = "^[a-zA-Z\\s]{2,30}$", message = "Invalid Family")
    private String familyPayTo;

    @Column(name = "date")
    private LocalDateTime localDateTime;


}
