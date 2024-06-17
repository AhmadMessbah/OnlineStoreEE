package com.store.onlinestore.model.entity;


import jakarta.persistence.*;
import jdk.jfr.Name;
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

@NamedQueries({
    @NamedQuery(name = "ProductUnit.FindByName", query = "select u from unitEntity u where u.name like :name")
})

@Entity(name = "unitEntity")
@Table(name = "unit_tbl")
public class ProductUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "description")
    private String description;


}
