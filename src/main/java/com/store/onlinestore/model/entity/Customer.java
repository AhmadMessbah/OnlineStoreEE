package com.store.onlinestore.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.NamedQuery;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@Entity(name = "customerEntity")
@Table(name="customer_tbl")
@NamedQueries({
        @NamedQuery(name = "Customer.FindByUsername", query = "select c from customerEntity c where c.userName like :username ),
                @NamedQuery(name = "Customer.findByUsernameAndPassword", query = "select c from customerEntity c where c.userName =:username and c.password =:password")
})
public class Customer {

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

    @Column(name="phone_number", length = 15, unique = true)
    @Pattern(regexp = "^(09|\\+989)\\d{9}$" ,message = "Invalid PhoneNumber")
    private String phoneNumber;

    @Column(name="email", length = 50)
    @Pattern(regexp = "^\\w{3,35}@(gmail|yahoo|microsoft)\\.com$" ,message = "Invalid Email")
    private String email;

    @Column(name = "username", length = 20, unique = true, nullable = false)
    @Pattern(regexp = "^[A-Za-z]{3,30}$", message = "Invalid UserName")
    private String userName;

    @Column(name = "password", length = 30, nullable = false)
    @Pattern(regexp = "^[A-Za-z]{8,30}$", message = "Invalid Password")
    private String password;

    @Column(name="address", length = 100)
    @Pattern(regexp = "^[A-Za-z]{10,100}$" ,message = "Invalid Address")
    private String address;

    @OneToOne
    private Role role;

}
