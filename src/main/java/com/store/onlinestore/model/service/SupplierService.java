package com.store.onlinestore.model.service;

import com.store.onlinestore.controller.exception.SupplierNotFoundException;
import com.store.onlinestore.model.entity.Supplier;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SupplierService {
    @Getter
    private static SupplierService service = new SupplierService();

    private SupplierService(){}

    public Supplier save(Supplier supplier) throws Exception {
        try(CrudRepository<Supplier , Long> repository = new CrudRepository<>()){
            return repository.save(supplier);
        }
    }

    public Supplier edit(Supplier supplier) throws Exception {
        try(CrudRepository<Supplier , Long> repository = new CrudRepository<>()){
            return repository.edit(supplier);
        }
    }
    public Supplier remove(Long id) throws Exception {
        try (CrudRepository<Supplier, Long> repository = new CrudRepository<>()) {
            if (repository.findById(id, Supplier.class) != null) {
                return repository.remove(id, Supplier.class);
            }
            throw new SupplierNotFoundException();
        }
    }

        public List<Supplier> findAll() throws Exception {
        try (CrudRepository<Supplier, Long> repository = new CrudRepository<>()) {
            return repository.findAll(Supplier.class);
        }
    }
    public Supplier findById(Long id) throws Exception {
        try(CrudRepository<Supplier , Long> repository = new CrudRepository<>()){
            return repository.findById(id , Supplier.class);
        }
    }

    public List<Supplier> findByNameAndFamily(String name, String family) throws Exception {
        try (CrudRepository<Supplier, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("name", name+"%");
            params.put("family", family+"%");
            return repository.executeQuery("supplier.FindByNameAndFamily", params, Supplier.class);
        }
    }
    public Supplier findByMobilePhone(String mobilePhone) throws Exception {
        try (CrudRepository<Supplier, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("mobilePhone", mobilePhone);
            List<Supplier> result = repository.executeQuery("supplier.FindByMobilePhone", params, Supplier.class);
            if (result.isEmpty()) {
                return null;
            } else {
                return result.get(0);
            }
        }
    }
    public Supplier findByNationalCode(String nationalCode) throws Exception {
        try (CrudRepository<Supplier, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("nationalCode", nationalCode);
            List<Supplier> result = repository.executeQuery("supplier.findByNationalCode", params, Supplier.class);
            if (result.isEmpty()) {
                return null;
            } else {
                return result.get(0);
            }
        }
    }

    public List<Supplier> findByCompany(String company) throws Exception {
        try (CrudRepository<Supplier, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("company", company+"%");
            return repository.executeQuery("supplier.findByCompany", params, Supplier.class);
        }
    }
}
