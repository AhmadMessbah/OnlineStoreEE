package com.store.onlinestore.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@Entity(name = "productGroupEntity")
@Table(name="product_group_tbl")
@NamedQueries({
        @NamedQuery(name = "ProductGroup.FindByName", query = "select p from productGroupEntity  p where p.name like :name "),
        @NamedQuery(name = "ProductGroup.FindByStatus", query = "select p from productGroupEntity p where p.status =:status")
})
public class ProductGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 30, unique = true)
    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$" ,message = "Invalid Name")
    private String name;

    @Column(name = "description", length = 30)
    private String description;

    @Column(name = "is_active")
    private boolean status;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "product_group_relation_tbl")
    private ProductGroup parentGroup;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "parentGroup")
    private List<ProductGroup> childGroupList;

}
