package com.store.onlinestore.model.service;

import com.store.onlinestore.controller.exception.TransactionNotFoundException;
import com.store.onlinestore.model.entity.Inventory;
import com.store.onlinestore.model.entity.InventoryTransaction;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;

import java.time.LocalDateTime;
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
            throw new TransactionNotFoundException();
        }
    }

    public List<InventoryTransaction> findAll() throws Exception {
        try (CrudRepository<InventoryTransaction, Long> repository = new CrudRepository<>()) {
            return repository.findAll(InventoryTransaction.class);
        }
    }

    public List<InventoryTransaction> findByDeliverPerson(String name, String family) throws Exception {
        try (CrudRepository<InventoryTransaction, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("name", name + "%");
            params.put("family", family + "%");
            return repository.executeQuery("FindByDeliverPerson", params, InventoryTransaction.class);
        }
    }

    public List<InventoryTransaction> findByReceiverPerson(String name, String family) throws Exception {
        try (CrudRepository<InventoryTransaction, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("name", name + "%");
            params.put("family", family + "%");
            return repository.executeQuery("FindByReceiverPerson", params, InventoryTransaction.class);
        }
    }

    public List<InventoryTransaction> findByProductID(Long productId) throws Exception {
        try (CrudRepository<InventoryTransaction, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("productId", productId);
            return repository.executeQuery("findByProductId", params, InventoryTransaction.class);
        }
    }

    //    public InventoryTransaction findByPhoneNumber(String phoneNumber) throws Exception {
//        try (CrudRepository<InventoryTransaction, Long> repository = new CrudRepository<>()) {
//            Map<String, Object> params = new HashMap<>();
//            params.put("phoneNumber", phoneNumber);
//            List<InventoryTransaction> result = repository.executeQuery("FindByPhoneNumber", params, InventoryTransaction.class);
//            if (result.isEmpty()) {
//                return null;
//            } else {
//                return result.get(0);
//            }
//        }
//    }
    public InventoryTransaction findByRegisterDateTime(LocalDateTime registerDateTime) throws Exception {
        try (CrudRepository<InventoryTransaction, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("registerDateTime", registerDateTime);
            List<InventoryTransaction> result = repository.executeQuery("FindByRegisterDateTime", params, InventoryTransaction.class);
            if (result.isEmpty()) {
                return null;
            } else {
                return result.get(0);
            }
        }
    }
}
