package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.Inventory;
import com.store.onlinestore.model.entity.Person;
import com.store.onlinestore.model.entity.Product;
import com.store.onlinestore.model.entity.TransactionInventory;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryService {
    @Getter
    private static InventoryService service = new InventoryService();
    
    private InventoryService(){}

    public Inventory save(Inventory inventory) throws Exception {
        try (CrudRepository<Inventory , Long> repository = new CrudRepository<>()) {
            return repository.save(inventory);
        }
    }
    public Inventory edit(Inventory inventory) throws Exception {
        try (CrudRepository<Inventory , Long> repository = new CrudRepository<>()) {
            return repository.edit(inventory);
        }
    }
    public Inventory remove(Long id) throws Exception {
        try (CrudRepository<Inventory, Long> repository = new CrudRepository<>()) {
            return repository.remove(id, Inventory.class);
        }
    }
    public List<Inventory> findAll() throws Exception {
        try (CrudRepository<Inventory, Long> repository = new CrudRepository<>()) {
            return repository.findAll(Inventory.class);
        }
    }
    // TODO: 6/20/2024 check service find By Product
//    public List<Inventory> findByProduct(Product product) throws Exception {
//        try (CrudRepository<Inventory, Long> repository = new CrudRepository<>()) {
//            Map<String, Object> params = new HashMap<>();
//            params.put("product", product+"%");
//            return repository.executeQuery("Inventory.FindByproduct", params, Inventory.class);
//        }
//    }
    public List<Inventory> findByName(String name) throws Exception {
        try (CrudRepository<Inventory, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("name", name+"%");
            return repository.executeQuery("Inventory.FindByName", params, Inventory.class);
        }
    }
}
