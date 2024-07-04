package com.store.onlinestore.model.entity;

import com.store.onlinestore.model.entity.enums.UserState;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@MappedSuperclass
public abstract class User extends Base {

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

    @Column(name="email", length = 50)
//    @Pattern(regexp = "^\\w{3,35}@(gmail|yahoo|microsoft)\\.com$" ,message = "Invalid Email")
    private String email;

    @Column(name="phone_number", length = 15, unique = true)
//    @Pattern(regexp = "^(09|\\+989)\\d{9}$" ,message = "Invalid PhoneNumber")
    private String phoneNumber;

    @Column(name = "nationalCode", length = 10)
//    @Pattern(regexp = "^//d{10}$")
    private String nationalCode;


    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Address address;

    @Enumerated
    private UserState status;

}

