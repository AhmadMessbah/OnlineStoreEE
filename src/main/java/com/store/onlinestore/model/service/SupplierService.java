package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.Person;
import com.store.onlinestore.model.entity.Supplier;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;

import java.security.PublicKey;
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
    public Supplier remove(long id) throws Exception {
        try(CrudRepository<Supplier , Long> repository = new CrudRepository<>()){
          return repository.remove(id , Supplier.class);
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
    public Supplier fideByNationalCode(String nationalCode) throws Exception {
        try (CrudRepository<Supplier, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("nationalCode", nationalCode);
            List<Supplier> result = repository.executeQuery("supplier.FideByNationalCode", params, Supplier.class);
            if (result.isEmpty()) {
                return null;
            } else {
                return result.get(0);
            }
        }
    }
}
