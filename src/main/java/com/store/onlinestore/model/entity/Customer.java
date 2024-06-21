package com.store.onlinestore.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@Entity(name = "customerEntity")
@Table(name="customer_tbl")
@NamedQueries({
        @NamedQuery(name = "Customer.FindByNameAndFamily", query = "select p from customerEntity p where p.name like :name and p.family like :family"),
        @NamedQuery(name = "Customer.FindByUsername", query = "select p from customerEntity p where p.username =:username"),
        @NamedQuery(name = "Customer.FindByPhoneNumber", query = "select p from customerEntity p where p.phoneNumber =:phoneNumber")
})

public class Customer extends User {
    @Id
    @SequenceGenerator(name = "customerSeq", sequenceName = "customer_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerSeq")
    @Column(name = "id")
    private Long id;

    @Column(name="phone_number", length = 15, unique = true)
//    @Pattern(regexp = "^(09|\\+989)\\d{9}$" ,message = "Invalid PhoneNumber")
    private String phoneNumber;

    @Column(name="email", length = 50)
//    @Pattern(regexp = "^\\w{3,35}@(gmail|yahoo|microsoft)\\.com$" ,message = "Invalid Email")
    private String email;

//    @OneToOne
//    private Address address;

    @OneToOne
    private Role role ;
}

