package com.store.onlinestore.model.service;


import com.store.onlinestore.model.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


import java.util.List;


public class ProductService {


    @PersistenceContext(unitName = "store")
    private EntityManager entityManager;

    public Product save(Product product) throws Exception {
        entityManager.persist(product);
        return product;
    }

    public Product edit(Product product) throws Exception {
        product = entityManager.find(Product.class, product.getId());
        if (product != null) {
            entityManager.merge(product);
        }
        return product;
    }

    public Product remove(Long id) throws Exception {
        Product product = entityManager.find(Product.class, id);
        if (product != null) {
            product.setDeleted(true);
            entityManager.merge(product);
        }
        return product;

    }

    public List<Product> findAll() throws Exception {
        return entityManager.createQuery("select p from productEntity p where p.deleted=false ", Product.class).getResultList();
    }

    public Product findById(Long id) throws Exception {
        Product product = entityManager.find(Product.class, id);
        return product;

    }

    public List<Product> findByNameAndBrand(String name, String brand) throws Exception {
        return entityManager
                .createQuery("select p from productEntity p where p.name like :name and p.brand like :brand", Product.class)
                .setParameter("name", name + "%")
                .setParameter("brand", brand + "%")
                .getResultList();
    }

    public Product FindByBarcode(String barcode) throws Exception {
        return entityManager
                .createQuery("select p from productEntity p where p.barcode =:barcode", Product.class)
                .setParameter("barcode", barcode)
                .getSingleResult();
    }

    public List<Product> FindByBrand(String brand) throws Exception {
        List<Product> result = null;
        result = entityManager
                .createQuery("select p from productEntity p where p.brand like :brand", Product.class)
                .setParameter("brand", brand + "%")
                .getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result;
        }
    }
}



