package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.CashPayment;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public CashPayment FindByDateTime(LocalDateTime dateTime) throws Exception {
        try (CrudRepository<CashPayment, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("DateTime", dateTime);
            List<CashPayment> result = repository.executeQuery( "Cash.FindByDateTime", params, CashPayment.class);
            if (result.isEmpty()) {
                return null;
            } else {
                return result.get(0);
            }
        }
    }
}

