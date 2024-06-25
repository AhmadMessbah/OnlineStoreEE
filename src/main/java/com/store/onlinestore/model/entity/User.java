package com.store.onlinestore.model.entity;

import com.store.onlinestore.model.entity.enums.UserState;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.json.bind.annotation.JsonbTransient;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@MappedSuperclass
public abstract class User {

    @Column(name="name", length = 30, nullable = false)
    //@Pattern(regexp = "^[a-zA-Z\\s]{3,30}$" ,message = "Invalid Name")
    private String name;

    @Column(name="family", length = 30, nullable = false)
    //@Pattern(regexp = "^[a-zA-Z\\s]{3,30}$" ,message = "Invalid Family")
    private String family;

    @Column(name="username", length = 30 ,unique = true ,nullable = false)
    //@Pattern(regexp = "^[a-zA-Z\\d\\S\\._]{3,30}$" ,message = "Invalid username")
    private String username;

    @Column(name="password", length = 15, nullable = false)
  //  @Pattern(regexp = "^[\\w\\S]{3,30}$" ,message = "Invalid Password")
    private String password;

    @Enumerated
    private UserState status;

    @JsonbTransient
    private Boolean deleted;
}

