package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.TransactionInventory;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionService {
    @Getter
    private static TransactionService service = new TransactionService();

    private TransactionService(){}
    public TransactionInventory save(TransactionInventory transactionInventory) throws Exception {
        try (CrudRepository<TransactionInventory, Long> repository = new CrudRepository<>()) {
            return repository.save(transactionInventory);
        }
    }
    public TransactionInventory edit(TransactionInventory transactionInventory) throws Exception {
        try (CrudRepository<TransactionInventory, Long> repository = new CrudRepository<>()) {
            return repository.edit(transactionInventory);
        }
    }
    public TransactionInventory remove(Long id) throws Exception {
        try (CrudRepository<TransactionInventory, Long> repository = new CrudRepository<>()) {
            return repository.remove(id, TransactionInventory.class);
        }
    }
    public List<TransactionInventory> findAll() throws Exception {
        try (CrudRepository<TransactionInventory, Long> repository = new CrudRepository<>()) {
            return repository.findAll(TransactionInventory.class);
        }
    }
    public List<TransactionInventory> findByNameAndFamily(String name, String family) throws Exception {
        try (CrudRepository<TransactionInventory, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("name", name+"%");
            params.put("family", family+"%");
            return repository.executeQuery("TransactionInventory.FindByNameAndFamily", params, TransactionInventory.class);
        }
    }
    public TransactionInventory findByPhoneNumber(String phoneNumber) throws Exception {
        try (CrudRepository<TransactionInventory, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("phoneNumber", phoneNumber);
            List<TransactionInventory> result = repository.executeQuery("TransactionInventory.FindByPhoneNumber", params, TransactionInventory.class);
            if (result.isEmpty()) {
                return null;
            } else {
                return result.get(0);
            }
        }
    }
}
