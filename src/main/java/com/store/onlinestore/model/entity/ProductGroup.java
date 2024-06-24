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
@NamedQueries({
        @NamedQuery(name = "ProductGroup.FindByName", query = "select p from productGroupEntity  p where p.name like :name "),
        @NamedQuery(name = "ProductGroup.FindByStatus", query = "select p from productGroupEntity p where p.status =:status"),
        @NamedQuery(name = "ProductGroup.FindByParentName", query = "select p from productGroupEntity p where p.parentGroup.name =:name")

})
public class ProductGroup {
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

    // TODO: ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) روی این حالت باشد این خطا را میدهد cascade اگر
    // TODO: Converting `org.hibernate.PersistentObjectException` to JPA `PersistenceException` : detached entity passed to persist: com.store.onlinestore.model.entity.ProductGroup
    @ManyToOne
    @JoinTable(name = "product_group_relation_tbl")
    private ProductGroup parentGroup;

    // TODO: نباشد این خطا را میدهد fetch = FetchType.EAGER اگر
    // TODO: failed to lazily initialize a collection of role: com.store.onlinestore.model.entity.ProductGroup.childGroupList: could not initialize proxy - no Session
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER, mappedBy = "parentGroup")
    private List<ProductGroup> childGroupList;


    public void addChildGroup(ProductGroup childGroup){
        if (childGroupList == null){
            childGroupList = new ArrayList<>();
        }
        childGroupList.add(childGroup);
    }

}
