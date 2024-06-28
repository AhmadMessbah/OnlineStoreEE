package com.store.onlinestore.model.service;

import com.store.onlinestore.controller.exception.InventoryTransactionNotFoundException;
import com.store.onlinestore.model.entity.InventoryTransaction;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryTransactionService {
    @Getter
    private static InventoryTransactionService service = new InventoryTransactionService();

    private InventoryTransactionService() {
    }

    public InventoryTransaction save(InventoryTransaction inventoryTransaction) throws Exception {
        try (CrudRepository<InventoryTransaction, Long> repository = new CrudRepository<>()) {
            return repository.save(inventoryTransaction);
        }
    }

    public InventoryTransaction edit(InventoryTransaction inventoryTransaction) throws Exception {
        try (CrudRepository<InventoryTransaction, Long> repository = new CrudRepository<>()) {
            return repository.edit(inventoryTransaction);
        }
    }

    public InventoryTransaction remove(Long id) throws Exception {
        try (CrudRepository<InventoryTransaction, Long> repository = new CrudRepository<>()) {
            if (repository.findById(id, InventoryTransaction.class) != null) {
                return repository.remove(id, InventoryTransaction.class);
            }
            throw new InventoryTransactionNotFoundException();
        }
    }

    public List<InventoryTransaction> findAll() throws Exception {
        try (CrudRepository<InventoryTransaction, Long> repository = new CrudRepository<>()) {
            return repository.findAll(InventoryTransaction.class);
        }
    }

    public InventoryTransaction findByDeliverPerson(String name, String family) throws Exception {
        try (CrudRepository<InventoryTransaction, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("name", name + "%");
            params.put("family", family + "%");
            List<InventoryTransaction> result = repository.executeQuery("InventoryTransaction.FindByDeliverPerson", params, InventoryTransaction.class);
            if (result.isEmpty()) {
                return null;
            } else {
                return result.get(0);
            }
        }
    }

    public InventoryTransaction findByPhoneNumber(String phone) throws Exception {
        try (CrudRepository<InventoryTransaction, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("phoneNumber", phone + "%");
            List<InventoryTransaction> result = repository.executeQuery("InventoryTransaction.FindByPhoneNumber", params, InventoryTransaction.class);
            if (result.isEmpty()) {
                return null;
            } else {
                return result.get(0);
            }
        }
    }
}
