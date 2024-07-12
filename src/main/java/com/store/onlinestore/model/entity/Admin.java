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

public class Admin extends Profile {
    @Id
    @SequenceGenerator(name = "adminSeq", sequenceName = "admin_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adminSeq")
    @Column(name = "id")
    private Long id;

    @OneToOne
    // TODO: join column
    //@JoinColumn(name = "Admin_role_table")
    private Role role ;
    @OneToOne
    // TODO: join column
    //@JoinColumn(name = "Admin_role_table")
    private User user ;
}

