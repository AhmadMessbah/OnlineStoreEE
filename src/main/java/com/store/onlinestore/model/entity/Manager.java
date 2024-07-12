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


public class Manager extends Profile{
    @Id
    @SequenceGenerator(name = "managerSeq", sequenceName = "manager_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "managerSeq")
    @Column(name = "id")
    private Long id;

    @OneToOne
    private Role role ;

    @OneToOne
    // TODO: join column
    //@JoinColumn(name = "Admin_role_table")
    private User user ;
}


