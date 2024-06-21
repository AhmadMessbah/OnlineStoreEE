package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.CheckPayment;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckService {
    @Getter
    private static CheckService service = new CheckService();

    CheckService() {
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

    public List<CheckPayment> findByNameAndFamily(String name, String family) throws Exception {
        try (CrudRepository<CheckPayment, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("name", name+"%");
            params.put("family", family+"%");
            return repository.executeQuery("Check.FindByNameAndFamily", params, CheckPayment.class);
        }
    }

}
