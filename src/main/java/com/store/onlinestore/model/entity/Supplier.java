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

public class Supplier extends Base {
    @Id
    @SequenceGenerator(name = "managerSeq", sequenceName = "manager_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "managerSeq")
    @Column(name = "id")
    private Long id;

    @Column(name = "company_name")
//    @Pattern(regexp = "^[a-zA-Z\\s\\d]{3,50}$" ,message = "Invalid Company Name")
    private String companyName;

    @OneToOne
    private User user;
}
