package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.Cash;
import com.store.onlinestore.model.entity.Check;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;

import java.util.List;

public class CashService {
    @Getter
    private static CashService service = new CashService();

    private CashService(){
    }

    public Cash save(Cash cash) throws Exception {
        try (CrudRepository<Cash, Long> repository = new CrudRepository<>()) {
            return repository.save(cash);
        }
    }

    public Cash edit(Cash cash) throws Exception {
        try (CrudRepository<Cash, Long> repository = new CrudRepository<>()) {
            return repository.edit(cash);
        }
    }

    public Cash remove(Long id) throws Exception {
        try (CrudRepository<Cash, Long> repository = new CrudRepository<>()) {
            return repository.remove(id, Cash.class);
        }
    }

    public List<Cash> findAll() throws Exception {
        try (CrudRepository<Cash, Long> repository = new CrudRepository<>()) {
            return repository.findAll(Cash.class);
        }
    }

    public Cash findById(Long id) throws Exception {
        try (CrudRepository<Cash, Long> repository = new CrudRepository<>()) {
            return repository.findById(id, Cash.class);
        }
    }
}
