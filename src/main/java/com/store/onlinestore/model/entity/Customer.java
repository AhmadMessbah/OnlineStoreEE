package com.store.onlinestore.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "customerEntity")
@Table(name="customer_tbl")
@NamedQueries({
        @NamedQuery(name = "Customer.FindByNameAndFamily", query = "select p from customerEntity p where p.name like :name and p.family like :family"),
        @NamedQuery(name = "Customer.FindByUsernameAndPassword", query = "select p from customerEntity p where p.username=:username and p.password=:password"),
        @NamedQuery(name = "Customer.FindByUsername", query = "select p from customerEntity p where p.username=:username"),
        @NamedQuery(name = "Customer.FindByNationalCode", query = "select p from customerEntity p where p.nationalCode=:nationalCode"),
        @NamedQuery(name = "Customer.FindByEmail", query = "select p from customerEntity p where p.email like :email"),
        @NamedQuery(name = "Customer.FindByPhoneNumber", query = "select p from customerEntity p where p.phoneNumber =:phoneNumber")
})

public class Customer extends User {
    @Id
    @SequenceGenerator(name = "customerSeq", sequenceName = "customer_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerSeq")
    @Column(name = "id")
    private Long id;


    @OneToOne
    @JoinTable(name="user_roles")
    private Role role ;
}

