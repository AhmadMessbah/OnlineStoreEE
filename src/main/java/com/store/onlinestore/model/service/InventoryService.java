package com.store.onlinestore.model.service;

import com.store.onlinestore.controller.exception.InventoryNotFoundException;
import com.store.onlinestore.model.entity.Inventory;
import com.store.onlinestore.model.entity.Supplier;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryService {
    @Getter
    private static InventoryService service = new InventoryService();

    private InventoryService() {
    }

    public Inventory save(Inventory inventory) throws Exception {
        try (CrudRepository<Inventory, Long> repository = new CrudRepository<>()) {
            return repository.save(inventory);
        }
    }

    public Inventory edit(Inventory inventory) throws Exception {
        try (CrudRepository<Inventory, Long> repository = new CrudRepository<>()) {
            return repository.edit(inventory);
        }
    }

    public Inventory remove(Long id) throws Exception {
        try (CrudRepository<Inventory, Long> repository = new CrudRepository<>()) {
            if (repository.findById(id, Inventory.class) != null) {
                return repository.remove(id, Inventory.class);
            }
            throw new InventoryNotFoundException();
        }
    }

    public List<Inventory> findAll() throws Exception {
        try (CrudRepository<Inventory, Long> repository = new CrudRepository<>()) {
            return repository.findAll(Inventory.class);
        }
    }

    public Inventory findById(Long id) throws Exception {
        try (CrudRepository<Inventory, Long> repository = new CrudRepository<>()) {
            return repository.findById(id, Inventory.class);
        }
    }


    public List<Inventory> findByProductID(Long productId) throws Exception {
        try (CrudRepository<Inventory, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("productId", productId+"%");
            return repository.executeQuery("findByProductId", params, Inventory.class);
        }
    }
    public List<Inventory> findByName(String name) throws Exception {
        try (CrudRepository<Inventory, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("name", name + "%");
            return repository.executeQuery("findByInventoryName", params, Inventory.class);
        }
    }

    public Supplier findByInventoryNumber(String inventoryNumber) throws Exception {
        try (CrudRepository<Inventory, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("inventoryNumber", inventoryNumber + "%");
            return (Supplier) repository.executeQuery("findByCompany", params, Inventory.class);
        }
    }
}
