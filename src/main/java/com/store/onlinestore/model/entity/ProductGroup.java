package com.store.onlinestore.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString


@Entity(name = "productGroupEntity")
@Table(name="product_group_tbl")

public class ProductGroup extends Base{
    @Id
    @SequenceGenerator(name = "productGroupSeq", sequenceName = "product_group_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productGroupSeq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 30, unique = true)
    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$" ,message = "Invalid Name")
    private String name;

    @Column(name = "description", length = 50)
    private String description;

    @Column(name = "is_active")
    private boolean status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_group_id")
    private ProductGroup parentGroup;

    @ToString.Exclude
    @OneToMany( fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "parentGroup")
    private List<ProductGroup> childGroupList;


    public void addChildGroup(ProductGroup childGroup){
        if (childGroupList == null){
            childGroupList = new ArrayList<>();
        }
        childGroupList.add(childGroup);
    }


}
