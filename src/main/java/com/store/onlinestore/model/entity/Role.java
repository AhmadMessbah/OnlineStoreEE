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

public class Role extends Base {
    @Id
    @Column(name = "role_name")
    private String role;
}
