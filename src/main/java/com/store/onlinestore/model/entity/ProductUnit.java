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


@NamedQueries({
    @NamedQuery(name = "ProductUnit.FindByName", query = "select u from productUnitEntity u where u.name like :name"),
    @NamedQuery(name = "ProductUnit.FindBySymbol", query = "select u from productUnitEntity u where u.symbol =:symbol")
})

@Entity(name = "productUnitEntity")
@Table(name = "product_unit_tbl")
public class ProductUnit extends Base {
    @Id
    @SequenceGenerator(name = "productUnitSeq", sequenceName = "product-unit-seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productUnitSeq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 30)
//    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$" ,message = "Invalid Name")
    private String name;

    @Column(name = "symbol")
//    @Pattern(regexp = "^[a-zA-Z\\d]{3,30}$", message = "Invalid Symbol")
    private String symbol;

    @Column(name = "description")
    private String description;

}
