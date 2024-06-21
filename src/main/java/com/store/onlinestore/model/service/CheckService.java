package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.Card;
import com.store.onlinestore.model.entity.Check;
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

    public Check save(Check check) throws Exception {
        try (CrudRepository<Check, Long> repository = new CrudRepository<>()) {
            return repository.save(check);
        }
    }

    public Check edit(Check check) throws Exception {
        try (CrudRepository<Check, Long> repository = new CrudRepository<>()) {
            return repository.edit(check);
        }
    }

    public Check remove(Long id) throws Exception {
        try (CrudRepository<Check, Long> repository = new CrudRepository<>()) {
            return repository.remove(id, Check.class);
        }
    }

    public List<Check> findAll() throws Exception {
        try (CrudRepository<Check, Long> repository = new CrudRepository<>()) {
            return repository.findAll(Check.class);
        }
    }

    public Check findById(Long id) throws Exception {
        try (CrudRepository<Check, Long> repository = new CrudRepository<>()) {
            return repository.findById(id, Check.class);
        }
    }

    public List<Check> findByNameAndFamily(String name, String family) throws Exception {
        try (CrudRepository<Check, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("name", name+"%");
            params.put("family", family+"%");
            return repository.executeQuery("Check.FindByNameAndFamily", params, Check.class);
        }
    }

}
