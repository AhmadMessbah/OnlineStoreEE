package com.store.onlinestore.model.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@NoArgsConstructor
@SuperBuilder

@Entity(name = "supplierEntity")
@Table(name = "supplier_tbl")
@NamedQueries({
        @NamedQuery(name = "Supplier.FindByNameAndFamily", query = "select p from supplierEntity p where p.name like :name and p.family like :family"),
        @NamedQuery(name = "Supplier.FindByMobilePhone", query = "select p from supplierEntity p where p.mobilePhone=:mobilePhone"),
        @NamedQuery(name = "Supplier.FindByNationalCode", query = "select p from supplierEntity p where p.nationalCode=:nationalCode"),
        @NamedQuery(name = "Supplier.FindByCompany", query = "select p from supplierEntity p where p.companyName like :company")
})
public class Supplier extends Base {
    @Id
    @SequenceGenerator(name = "supplierSeq", sequenceName = "supplier_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplierSeq")
    private Long id;

    @Column(name = "name")
//    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$" ,message = "Invalid Name")
    private String name;

    @Column(name = "family")
//    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$" , message = "Invalid Family")
    private String family;

    @Column(name = "mobile")
//    @Pattern(regexp = "^(09|\\+989)\\d{9}$" ,message = "Invalid MobileNumber")
    private String mobilePhone;

    @Column(name = "nationalCode", length = 10)
//    @Pattern(regexp = "^//d{10}$")
    private String nationalCode;

    @Column(name = "email", length = 50)
//    @Pattern(regexp = "^\\w{3,35}@(gmail|yahoo|microsoft)\\.com$" ,message = "Invalid Email")
    private String email;

    @Column(name = "company_name")
//    @Pattern(regexp = "^[a-zA-Z\\s\\d]{3,50}$" ,message = "Invalid Company Name")
    private String companyName;


    @OneToOne
    @JoinTable(name = "role_relation_tbl")
    private Role role ;
}
