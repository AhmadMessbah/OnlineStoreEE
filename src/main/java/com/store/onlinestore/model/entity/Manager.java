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

@Entity(name = "managerEntity")
@Table(name="manager_tbl")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name="name", length = 30)
    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$" ,message = "Invalid Name")
    private String name;

    @Column(name="family", length = 30)
    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$" ,message = "Invalid Family")
    private String family;

    @Column(name="password", length = 15)
    @Pattern(regexp = "123admin" ,message = "Invalid Password")
    private String password;

    @Column(name="email", length = 50)
    @Pattern(regexp = "^\\w{3,35}@(gmail|yahoo|microsoft)\\.com$" ,message = "Invalid Email")
    private String email;

    @Column(name="image", length = 50)
    private String image;

    @OneToOne
    private Role role ;
}

