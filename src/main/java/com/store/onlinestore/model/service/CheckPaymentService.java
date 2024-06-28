package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.CheckPayment;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckPaymentService {

    @Getter
    private static CheckPaymentService service = new CheckPaymentService();

    CheckPaymentService() {
    }

    public CheckPayment save(CheckPayment checkPayment) throws Exception {
        try (CrudRepository<CheckPayment, Long> repository = new CrudRepository<>()) {
            return repository.save(checkPayment);
        }
    }

    public CheckPayment edit(CheckPayment checkPayment) throws Exception {
        try (CrudRepository<CheckPayment, Long> repository = new CrudRepository<>()) {
            return repository.edit(checkPayment);
        }
    }

    public CheckPayment remove(Long id) throws Exception {
        try (CrudRepository<CheckPayment, Long> repository = new CrudRepository<>()) {
            return repository.remove(id, CheckPayment.class);
        }
    }

    public List<CheckPayment> findAll() throws Exception {
        try (CrudRepository<CheckPayment, Long> repository = new CrudRepository<>()) {
            return repository.findAll(CheckPayment.class);
        }
    }

    public CheckPayment findById(Long id) throws Exception {
        try (CrudRepository<CheckPayment, Long> repository = new CrudRepository<>()) {
            return repository.findById(id, CheckPayment.class);
        }
    }

    public CheckPayment FindByCheckNumber(long checkNumber) throws Exception {
        try (CrudRepository<CheckPayment, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("checkNumber", checkNumber);
            List<CheckPayment> result = repository.executeQuery( "Check.FindByCheckNumber", params, CheckPayment.class);
            if (result.isEmpty()) {
                return null;
            } else {
                return result.get(0);
            }
        }
    }

    public CheckPayment FindByDateTime(LocalDateTime dateTime) throws Exception {
        try (CrudRepository<CheckPayment, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("DateTime", dateTime);
            List<CheckPayment> result = repository.executeQuery( "Check.FindByDateTime", params, CheckPayment.class);
            if (result.isEmpty()) {
                return null;
            } else {
                return result.get(0);
            }
        }
    }
}
