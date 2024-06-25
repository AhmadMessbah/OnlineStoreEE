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

@Entity(name = "adminEntity")
@Table(name="admin_tbl")
@NamedQueries({
        @NamedQuery(name = "Admin.FindByNameAndFamily", query = "select a from adminEntity a where a.name like :name and a.family like :family"),
        @NamedQuery(name = "Admin.FindByUsername", query = "select a from adminEntity a where a.username =:username and a.password =:password")
})

public class Admin extends User {
    @Id
    @SequenceGenerator(name = "adminSeq", sequenceName = "admin_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adminSeq")
    @Column(name = "id")
    private Long id;


    @OneToOne
    @JoinTable(name = "role_relation_tbl")
    private Role role ;
}

