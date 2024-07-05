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

@Entity(name = "roleEntity")
@Table(name="role_tbl")
@NamedQueries({
        @NamedQuery(name = "Role.FindById", query = "select r from roleEntity r where r.id = :id"),
        @NamedQuery(name = "Role.FindByRole", query = "select r from roleEntity r where r.role = :role")
})
public class Role extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "role_name", unique = true, nullable = false)
    private String role;
}
