package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.ProductGroup;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.Serializable;
import java.util.List;


@ApplicationScoped
public class ProductGroupService implements Serializable {


    @PersistenceContext(unitName = "store")
    private EntityManager entityManager;

    public ProductGroup save(ProductGroup productGroup) throws Exception {
        entityManager.persist(productGroup);
        return productGroup;
    }

    public ProductGroup edit(ProductGroup productGroup) throws Exception {
        ProductGroup foundProductGroup = entityManager.find(ProductGroup.class, productGroup.getId());
        if (foundProductGroup != null) {
            entityManager.merge(productGroup);
        }
        return productGroup;
    }

    public ProductGroup remove(Long id) throws Exception {
        ProductGroup productGroup = entityManager.find(ProductGroup.class, id);
        if (productGroup != null) {
            productGroup.setDeleted(true);
            entityManager.merge(productGroup);
        }
        return productGroup;
    }

    public List<ProductGroup> findAll() throws Exception {
        return entityManager
                .createQuery("select oo from productGroupEntity oo where oo.deleted=false", ProductGroup.class)
                .getResultList();
    }

    public ProductGroup findById(Long id) throws Exception {
        ProductGroup productGroup = entityManager.find(ProductGroup.class, id);
        return productGroup;
    }

    // TODO: 7/11/2024 getResultList??? 
    public ProductGroup findByName(String name) throws Exception {
        List<ProductGroup> productGroupList =
        entityManager
                .createQuery("select p from productGroupEntity  p where p.name =:name and p.deleted=false", ProductGroup.class)
                .setParameter("name", name)
                .getResultList();
        if (!productGroupList.isEmpty()){
            return productGroupList.get(0);
        } else {
            return null;
        }
    }

    public List<ProductGroup> findByStatus(boolean status) throws Exception {
        return entityManager
                .createQuery("select p from productGroupEntity  p where p.status =:status and p.deleted=false", ProductGroup.class)
                .setParameter("status", status)
                .getResultList();
    }

    public List<ProductGroup> findByParentName(String name) throws Exception {
        return entityManager
                .createQuery("select p from productGroupEntity  p where p.parentGroup.name =:name and p.deleted=false", ProductGroup.class)
                .setParameter("name", name)
                .getResultList();
    }

}