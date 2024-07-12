package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.ProductUnit;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.Serializable;
import java.util.List;
@ApplicationScoped
public class ProductUnitService implements Serializable {

    @PersistenceContext(unitName = "store")
    private EntityManager entityManager;

    public ProductUnit save(ProductUnit productUnit) throws Exception {
        entityManager.persist(productUnit);
        return productUnit;
    }

    public ProductUnit edit(ProductUnit productUnit) throws Exception {
        ProductUnit foundProductUnit = entityManager.find(ProductUnit.class, productUnit.getId());
        if (foundProductUnit != null) {
            entityManager.merge(productUnit);
        }
        return productUnit;
    }

    public ProductUnit remove(Long id) throws Exception {
        ProductUnit productUnit = entityManager.find(ProductUnit.class, id);
        if (productUnit != null) {
            productUnit.setDeleted(true);
            entityManager.merge(productUnit);
        }
        return productUnit;
    }

    public List<ProductUnit> findAll() throws Exception {
        return entityManager
                .createQuery("select oo from productUnitEntity oo where oo.deleted=false", ProductUnit.class)
                .getResultList();
    }

    public ProductUnit findById(Long id) throws Exception {
        ProductUnit productUnit = entityManager.find(ProductUnit.class, id);
        return productUnit;
    }

    public ProductUnit findByName(String name) throws Exception {
        List<ProductUnit> productUnitList = entityManager.createQuery(
                        "select oo from productUnitEntity oo where oo.name like :name and oo.deleted=false", ProductUnit.class)
                .setParameter("name", name)
                .getResultList();
        if (!productUnitList.isEmpty()) {
            return productUnitList.get(0);
        } else {
            return null;
        }


    }

    public ProductUnit findBySymbol(String symbol) throws Exception {
        ProductUnit productUnit = entityManager.createQuery(
                        "select oo from productUnitEntity oo where oo.symbol =:symbol and oo.deleted=false", ProductUnit.class)
                .setParameter("symbol", symbol)
                .getSingleResult();
        return productUnit;
    }
}



