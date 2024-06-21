package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.ProductUnit;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductUnitService {
    @Getter
    private static ProductUnitService service = new ProductUnitService();

    private ProductUnitService() {
    }

    public ProductUnit save(ProductUnit productUnit) throws Exception {
        try(CrudRepository<ProductUnit, Long> unitRepository = new CrudRepository<>()) {
            return unitRepository.save(productUnit);
        }
    }

    public ProductUnit edit(ProductUnit productUnit) throws Exception{
        try (CrudRepository<ProductUnit, Long> unitRepository = new CrudRepository<>()){
            return unitRepository.edit(productUnit);
        }
    }

    public ProductUnit remove(Long id) throws Exception {
        try(CrudRepository<ProductUnit, Long> unitRepository = new CrudRepository<>()) {
            return unitRepository.remove(id, ProductUnit.class);
        }
    }

    public List<ProductUnit> findAll() throws Exception{
        try (CrudRepository<ProductUnit, Long> unitRepository = new CrudRepository<>()) {
            return unitRepository.findAll(ProductUnit.class);
        }
    }

    public ProductUnit findById(Long id) throws Exception {
        try(CrudRepository<ProductUnit, Long> unitRepository = new CrudRepository<>()) {
            return unitRepository.findById(id, ProductUnit.class);
        }
    }

    public List<ProductUnit> findByName(String name) throws Exception {
        try(CrudRepository<ProductUnit, Long> unitRepository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("name", name);
            List<ProductUnit> unitList = unitRepository.executeQuery("ProductUnit.FindByName", params, ProductUnit.class);
            if (unitList != null) {
                return unitList;
            }
            throw new Exception();
        }
    }
}
