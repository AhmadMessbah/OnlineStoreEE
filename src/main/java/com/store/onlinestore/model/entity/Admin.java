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

@Entity(name = "adminEntity")
@Table(name="admin_tbl")
@NamedQueries({
        @NamedQuery(name = "Admin.FindByNameAndFamily", query = "select a from adminEntity  a where a.name like :name and a.family like :family"),
        @NamedQuery(name = "Admin.FindByUsernameAndPassword", query = "select a from adminEntity a where a.username like :username and a.password like :password"),
        @NamedQuery(name = "Admin.FindByUsername", query = "select a from adminEntity a where a.username like :username"),
        @NamedQuery(name = "Admin.FindByEmail", query = "select a from adminEntity a where a.email like :email"),
        @NamedQuery(name = "FideByNationalCode", query = "select a from adminEntity a where a.nationalCode like :nationalCode"),
        @NamedQuery(name = "Admin.FindByPhoneNumber", query = "select a from adminEntity a where a.phoneNumber =:phoneNumber")
})

public class Admin extends User {
    @Id
    @SequenceGenerator(name = "adminSeq", sequenceName = "admin_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adminSeq")
    @Column(name = "id")
    private Long id;

    @OneToOne
    // TODO: join column
    //@JoinColumn(name = "Admin_role_table")
    private Role role ;
}

