package com.store.onlinestore.model.service;

import com.store.onlinestore.controller.exception.InventoryNotEnoughException;
import com.store.onlinestore.controller.exception.InventoryNotFoundException;
import com.store.onlinestore.model.entity.Inventory;
import com.store.onlinestore.model.entity.InventoryTransaction;
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
            Inventory retrivedInventory = findByName(inventory.getProduct().getName());
            if (retrivedInventory != null) {
                int count = retrivedInventory.getProductStock() + inventory.getProductStock();
                if (count > 0) {
                    retrivedInventory.setProductStock(count);
                    return edit(retrivedInventory);
                }
                throw new InventoryNotEnoughException();
            }
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

    public Inventory findByProductID(Long productId) throws Exception {
        try (CrudRepository<Inventory, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("productId", productId + "%");
            List<Inventory> result = repository.executeQuery("findByProductId", params, Inventory.class);
            if (result.isEmpty()) {
                return null;
            } else {
                return result.get(0);
            }

        }
    }

    public Inventory findByName(String name) throws Exception {
        try (CrudRepository<Inventory, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("name", name + "%");
            List<Inventory> result = repository.executeQuery("findByInventoryName", params, Inventory.class);
            if (result.isEmpty()) {
                return null;
            } else {
                return result.get(0);
            }

        }
    }
}
