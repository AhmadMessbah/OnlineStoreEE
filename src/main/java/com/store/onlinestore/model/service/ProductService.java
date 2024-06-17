package com.store.onlinestore.model.service;



import com.store.onlinestore.model.entity.Product;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
    @Getter
    private static ProductService service = new ProductService();
    private ProductService() {
    }

    public Product save(Product product) throws Exception {
        try (CrudRepository<Product, Long> repository = new CrudRepository<>()) {
            return repository.save(product);
        }
    }
    public Product edit(Product product) throws Exception {
        try (CrudRepository<Product, Long> repository = new CrudRepository<>()) {
            return repository.edit(product);
        }
    }

    //    todo : convert to logical remove
    public Product remove(Long id) throws Exception {
        try (CrudRepository<Product, Long> repository = new CrudRepository<>()) {
            return repository.remove(id, Product.class);
        }
    }
    public List<Product> findAll() throws Exception {
        try (CrudRepository<Product, Long> repository = new CrudRepository<>()) {
            return repository.findAll(Product.class);
        }
    }

    public Product findById(Long id) throws Exception {
        try (CrudRepository<Product, Long> repository = new CrudRepository<>()) {
            return repository.findById(id, Product.class);
        }
    }

    public List<Product> findByNameAndBrand(String name, String brand) throws Exception {
        try (CrudRepository<Product, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("name", name+"%");
            params.put("brand", brand+"%");
            return repository.executeQuery("Product.FindByNameAndBrand", params, Product.class);
        }
    }
    public Product FindByBarcode(String barcode) throws Exception {
        try (CrudRepository<Product, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("barcode", barcode);
            List<Product> result = repository.executeQuery("Product.FindByBarcode", params, Product.class);
            if (result.isEmpty()) {
                return null;
            } else {
                return result.get(0);
            }
        }
    }

    public List<Product>  FindByBrand(String brand) throws Exception {
        try (CrudRepository<Product, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("brand", brand+"%");
            List<Product> result = repository.executeQuery("Product.FindByBrand", params, Product.class);
            if (result.isEmpty()) {
                return null;
            } else {
                return result ;
            }
        }
    }







}
