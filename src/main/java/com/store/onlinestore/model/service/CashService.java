package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.CashPayment;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;

import java.util.List;

public class CashService {
    @Getter
    private static CashService service = new CashService();

    private CashService(){
    }

    public CashPayment save(CashPayment cashPayment) throws Exception {
        try (CrudRepository<CashPayment, Long> repository = new CrudRepository<>()) {
            return repository.save(cashPayment);
        }
    }

    public CashPayment edit(CashPayment cashPayment) throws Exception {
        try (CrudRepository<CashPayment, Long> repository = new CrudRepository<>()) {
            return repository.edit(cashPayment);
        }
    }

    public CashPayment remove(Long id) throws Exception {
        try (CrudRepository<CashPayment, Long> repository = new CrudRepository<>()) {
            return repository.remove(id, CashPayment.class);
        }
    }

    public List<CashPayment> findAll() throws Exception {
        try (CrudRepository<CashPayment, Long> repository = new CrudRepository<>()) {
            return repository.findAll(CashPayment.class);
        }
    }

    public CashPayment findById(Long id) throws Exception {
        try (CrudRepository<CashPayment, Long> repository = new CrudRepository<>()) {
            return repository.findById(id, CashPayment.class);
        }
    }
}
