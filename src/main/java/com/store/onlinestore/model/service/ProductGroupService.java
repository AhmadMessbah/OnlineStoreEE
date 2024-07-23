package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.ProductGroup;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;


@ApplicationScoped
public class ProductGroupService implements Serializable {


    @PersistenceContext(unitName = "store")
    private EntityManager entityManager;

    @Transactional
    public ProductGroup save(ProductGroup productGroup) throws Exception {
        entityManager.persist(productGroup);
        return productGroup;
    }

    @Transactional
    public ProductGroup edit(ProductGroup productGroup) throws Exception {
        ProductGroup foundProductGroup = entityManager.find(ProductGroup.class, productGroup.getId());
        if (foundProductGroup != null) {
            entityManager.merge(productGroup);
        }
        return productGroup;
    }

    @Transactional
    public ProductGroup remove(Long id) throws Exception {
        ProductGroup productGroup = entityManager.find(ProductGroup.class, id);
        if (productGroup != null) {
            productGroup.setDeleted(true);
            entityManager.merge(productGroup);
        }
        return productGroup;
    }

    @Transactional
    public List<ProductGroup> findAll() throws Exception {
        return entityManager
                .createQuery("select p from productGroupEntity p where p.deleted=false order by id", ProductGroup.class)
                .getResultList();
    }

    @Transactional
    public ProductGroup findById(Long id) throws Exception {
        return entityManager.find(ProductGroup.class, id);
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