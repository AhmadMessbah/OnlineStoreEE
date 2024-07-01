package com.store.onlinestore.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder


@Entity(name = "productGroupEntity")
@Table(name="product_group_tbl")
@NamedQueries({
        @NamedQuery(name = "ProductGroup.FindByName", query = "select p from productGroupEntity  p where p.name like :name and p.deleted=false"),
        @NamedQuery(name = "ProductGroup.FindByStatus", query = "select p from productGroupEntity p where p.status =:status and p.deleted=false"),
        @NamedQuery(name = "ProductGroup.FindByParentName", query = "select p from productGroupEntity p where p.parentGroup.name =:name and p.deleted=false")

})
public class ProductGroup extends Base{
    @Id
    @SequenceGenerator(name = "productGroupSeq", sequenceName = "product_group_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productGroupSeq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 30, unique = true)
//    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$" ,message = "Invalid Name")
    private String name;

    @Column(name = "description", length = 30)
    private String description;

    @Column(name = "is_active")
    private boolean status;

    @ManyToOne
    @JoinTable(name = "product_group_relation_tbl")
    private ProductGroup parentGroup;

    @OneToMany( fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "parentGroup")
    private List<ProductGroup> childGroupList;


    public void addChildGroup(ProductGroup childGroup){
        if (childGroupList == null){
            childGroupList = new ArrayList<>();
        }
        childGroupList.add(childGroup);
    }

}
