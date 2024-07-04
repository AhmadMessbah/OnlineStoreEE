package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.Manager;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerService {
    @Getter
    private static ManagerService service = new ManagerService();

    private ManagerService() {
    }

    public Manager save(Manager manager) throws Exception {
        try (CrudRepository<Manager, Long> repository = new CrudRepository<>()) {
            manager.setRole(RoleService.getService().FindByRole("manager"));
            return repository.save(manager);
        }
    }

    public Manager edit(Manager manager) throws Exception {
        try (CrudRepository<Manager, Long> repository = new CrudRepository<>()) {
            return repository.edit(manager);
        }
    }

    public Manager remove(Long id) throws Exception {
        try (CrudRepository<Manager, Long> repository = new CrudRepository<>()) {
            return repository.remove(id, Manager.class);
        }
    }

    public List<Manager> findAll() throws Exception {
        try (CrudRepository<Manager, Long> repository = new CrudRepository<>()) {
            return repository.findAll(Manager.class);
        }
    }

    public Manager findById(Long id) throws Exception {
        try (CrudRepository<Manager, Long> repository = new CrudRepository<>()) {
            return repository.findById(id, Manager.class);
        }
    }

    public List<Manager> findByUsername(String username) throws Exception {
        try (CrudRepository<Manager, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("username", username);
            return repository.executeQuery("Manager.FindByUsername", params, Manager.class);
        }
    }

    public List<Manager> findByNameAndFamily(String name, String family) throws Exception {
        try (CrudRepository<Manager, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("name", name+"%");
            params.put("family", family+"%");
            return repository.executeQuery("Manager.FindByNameAndFamily", params, Manager.class);
        }
    }

    public List<Manager> findByUsernameAndPassword(String username, String password) throws Exception {
        try (CrudRepository<Manager, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("username", username);
            params.put("password", password);
            return repository.executeQuery("Manager.FindByUsernameAndPassword", params, Manager.class);
        }
    }

    public List<Manager> findByEmail(String email) throws Exception {
        try (CrudRepository<Manager, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("email", email+"%");
            return repository.executeQuery("Manager.FindByEmail", params, Manager.class);
        }
    }

    public Manager findByPhoneNumber(String phoneNumber) throws Exception {
        try (CrudRepository<Manager, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("phoneNumber", phoneNumber);
            List<Manager> result = repository.executeQuery("Manager.FindByPhoneNumber", params, Manager.class);
            if (result.isEmpty()) {
                return null;
            } else {
                return result.get(0);
            }
        }
    }  public Manager fideByNationalCode(String nationalCode) throws Exception {
        try (CrudRepository<Manager, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("nationalCode", nationalCode);
            List<Manager> result = repository.executeQuery("FideByNationalCode", params, Manager.class);
            if (result.isEmpty()) {
                return null;
            } else {
                return result.get(0);
            }
        }
}}
