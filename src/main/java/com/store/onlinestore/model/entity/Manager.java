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

@Entity(name = "managerEntity")
@Table(name="manager_tbl")
@NamedQueries({
        @NamedQuery(name = "Manager.FindByNameAndFamily", query = "select p from managerEntity p where p.name like :name and p.family like :family"),
        @NamedQuery(name = "Manager.FindByUsernameAndPassword", query = "select p from managerEntity p where p.username like :username and p.password like :password"),
        @NamedQuery(name = "Manager.FindByUsername", query = "select p from managerEntity p where p.username like :username"),
        @NamedQuery(name = "Manager.FindByEmail", query = "select p from managerEntity p where p.email like :email"),
        @NamedQuery(name = "FideByNationalCode", query = "select p from supplierEntity p where p.nationalCode like :nationalCode"),
        @NamedQuery(name = "Manager.FindByPhoneNumber", query = "select p from managerEntity p where p.phoneNumber =:phoneNumber")
})

public class Manager extends User{
    @Id
    @SequenceGenerator(name = "managerSeq", sequenceName = "manager_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "managerSeq")
    @Column(name = "id")
    private Long id;

    @OneToOne
    private Role role ;
}

