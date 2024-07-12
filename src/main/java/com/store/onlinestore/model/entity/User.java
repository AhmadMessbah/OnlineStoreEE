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

@Entity(name = "userEntity")
@Table(name="user_tbl")

public class User extends Base{

    @Id
    @SequenceGenerator(name = "adminSeq", sequenceName = "admin_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adminSeq")
    @Column(name = "id")
    private Long id;

    @Column(name="username", length = 30 ,unique = true ,nullable = false)
    //@Pattern(regexp = "^[a-zA-Z\\d\\S\\._]{3,30}$" ,message = "Invalid username")
    private String username;

    @Column(name="password", length = 15, nullable = false)
    //  @Pattern(regexp = "^[\\w\\S]{3,30}$" ,message = "Invalid Password")
    private String password;

    @OneToOne
    // TODO: join column
    //@JoinColumn(name = "Admin_role_table")
    private Role role ;

}
