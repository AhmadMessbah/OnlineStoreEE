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
@NamedQueries({
        @NamedQuery(name = "Manager.FindByNameAndFamily", query = "select p from managerEntity p where p.name like :name and p.family like :family"),
        @NamedQuery(name = "Manager.FindByUsernameAndPassword", query = "select p from managerEntity p where p.username like :username and p.password like :password"),
        @NamedQuery(name = "Manager.FindByUsername", query = "select p from managerEntity p where p.username like :username"),
        @NamedQuery(name = "Manager.FindByEmail", query = "select p from managerEntity p where p.email like :email"),
        @NamedQuery(name = "Manager.FindByPhoneNumber", query = "select p from managerEntity p where p.phoneNumber =:phoneNumber")
})

public class Manager extends User{
    @Id
    @SequenceGenerator(name = "managerSeq", sequenceName = "manager_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "managerSeq")
    @Column(name = "id")
    private Long id;

    @Column(name="phone_number", length = 15, unique = true)
//    @Pattern(regexp = "^(09|\\+989)\\d{9}$" ,message = "Invalid PhoneNumber")
    private String phoneNumber;

    @Column(name="email", length = 50)
//    @Pattern(regexp = "^\\w{3,35}@(gmail|yahoo|microsoft)\\.com$" ,message = "Invalid Email")
    private String email;

    @OneToOne
    @JoinTable(name = "role_relation_tbl")
    private Role role ;
}

