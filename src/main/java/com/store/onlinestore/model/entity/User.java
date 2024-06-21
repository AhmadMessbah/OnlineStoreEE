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

@MappedSuperclass
public abstract class User {

    @Column(name="name", length = 30)
    //@Pattern(regexp = "^[a-zA-Z\\s]{3,30}$" ,message = "Invalid Name")
    private String name;

    @Column(name="family", length = 30)
    //@Pattern(regexp = "^[a-zA-Z\\s]{3,30}$" ,message = "Invalid Family")
    private String family;

    @Column(name="username", length = 30)
    //@Pattern(regexp = "^[a-zA-Z]{10,30}$" ,message = "Invalid username")
    private String username;

    @Column(name="password", length = 15)
    //@Pattern(regexp = "123admin" ,message = "Invalid Password")
    private String password;

//todo : status :)
   // @Column(name="status", length = 50)
   // @Pattern(regexp = "" ,message = "Invalid status")
    // private String status;


}

