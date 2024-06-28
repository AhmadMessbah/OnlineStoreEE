package com.store.onlinestore.model.service;

import com.store.onlinestore.controller.exception.DupcilateProductGroupException;
import com.store.onlinestore.controller.exception.ProductGroupNotFoundException;
import com.store.onlinestore.model.entity.ProductGroup;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductGroupService {

    @Getter
    private static ProductGroupService service = new ProductGroupService();

    private ProductGroupService() {
    }

    public ProductGroup save(ProductGroup productGroup) throws Exception {
        try (CrudRepository<ProductGroup, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("name", productGroup.getName());
            if (repository.executeQuery("ProductGroup.FindByName", params, ProductGroup.class).isEmpty()) {
                return repository.save(productGroup);

            }
            throw new DupcilateProductGroupException();
        }
    }

    public ProductGroup edit(ProductGroup productGroup) throws Exception {
        try (CrudRepository<ProductGroup, Long> repository = new CrudRepository<>()) {
            if (repository.findById(productGroup.getId(), ProductGroup.class) != null) {
                return repository.edit(productGroup);
            }
            throw new ProductGroupNotFoundException();
        }
    }

    public ProductGroup remove(Long id) throws Exception {
        try (CrudRepository<ProductGroup, Long> repository = new CrudRepository<>()) {
            if (repository.findById(id, ProductGroup.class) != null) {
                return repository.remove(id, ProductGroup.class);
            }
            throw new ProductGroupNotFoundException();
        }
    }

    public List<ProductGroup> findAll() throws Exception {
        try (CrudRepository<ProductGroup, Long> repository = new CrudRepository<>()) {
            List<ProductGroup> productGroupList = repository.findAll(ProductGroup.class);
            if (!productGroupList.isEmpty()) {
                return productGroupList;
            }
            throw new ProductGroupNotFoundException();
        }
    }

    public ProductGroup findById(Long id) throws Exception {
        try (CrudRepository<ProductGroup, Long> repository = new CrudRepository<>()) {
            ProductGroup productGroup = repository.findById(id, ProductGroup.class);
            if (productGroup != null) {
                return productGroup;
            }
            throw new ProductGroupNotFoundException();
        }
    }

    public ProductGroup findByName(String name) throws Exception {
        try (CrudRepository<ProductGroup, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("name", name);
            List<ProductGroup> productGroupList = repository.executeQuery("ProductGroup.FindByName", params, ProductGroup.class);
            if (!productGroupList.isEmpty()) {
                return productGroupList.get(0);

            }
            throw new ProductGroupNotFoundException();
        }
    }

    public List<ProductGroup> findByStatus(boolean status) throws Exception {
        try (CrudRepository<ProductGroup, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("status", status);
            List<ProductGroup> productGroupList = repository.executeQuery("ProductGroup.FindByStatus", params, ProductGroup.class);
            if (!productGroupList.isEmpty()) {
                return productGroupList;

            }
            throw new ProductGroupNotFoundException();
        }
    }

    public List<ProductGroup> findByParentName(String name) throws Exception {
        try (CrudRepository<ProductGroup, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("name", name);
            List<ProductGroup> productGroupList = repository.executeQuery("ProductGroup.FindByParentName", params, ProductGroup.class);
            if (!productGroupList.isEmpty()) {
                return productGroupList;
            }
            throw new ProductGroupNotFoundException();
        }
    }


}
