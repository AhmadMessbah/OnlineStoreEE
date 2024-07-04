package com.store.onlinestore.model.service;
import com.store.onlinestore.controller.exception.AdminNotFoundException;
import com.store.onlinestore.controller.exception.ProductGroupNotFoundException;
import com.store.onlinestore.model.entity.Admin;
import com.store.onlinestore.model.entity.Person;
import com.store.onlinestore.model.entity.ProductGroup;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminService {
    @Getter
    private static AdminService service = new AdminService();

    private AdminService() {}

    public Admin save(Admin admin) throws Exception {
        try (CrudRepository<Admin, Long> repository = new CrudRepository<>()) {
            admin.setRole(RoleService.getService().FindByRole("admin"));
            return repository.save(admin);
        }
    }

    public Admin edit(Admin admin) throws Exception {
        try (CrudRepository<Admin, Long> repository = new CrudRepository<>()) {
            return repository.edit(admin);
        }
    }

    public Admin remove(Long id) throws Exception {
        try (CrudRepository<Admin, Long> repository = new CrudRepository<>()) {
            if (repository.findById(id, Admin.class) != null) {
                return repository.remove(id, Admin.class);
            }
            throw new AdminNotFoundException();
        }
    }
    public List<Admin> findAll() throws Exception {
        try (CrudRepository<Admin, Long> repository = new CrudRepository<>()) {
            return repository.findAll(Admin.class);
        }
    }
    public Admin findById(Long id) throws Exception {
        try (CrudRepository<Admin, Long> repository = new CrudRepository<>()) {
            return repository.findById(id, Admin.class);
        }
    }
    public List<Admin> findByUsername(String username) throws Exception {
        try (CrudRepository<Admin, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("username", username);
            return repository.executeQuery("Admin.FindByUsername", params, Admin.class);
        }
    }

    public List<Admin> findByNameAndFamily(String name, String family) throws Exception {
        try (CrudRepository<Admin, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("name", name + "%");
            params.put("family", family + "%");
            return repository.executeQuery("Admin.FindByNameAndFamily", params, Admin.class);
        }
    }

    public List<Admin> findByUsernameAndPassword(String username, String password) throws Exception {
        try (CrudRepository<Admin, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("username", username);
            params.put("password", password);
            return repository.executeQuery("Admin.FindByUsernameAndPassword", params, Admin.class);
        }
    }
    public List<Admin> findByEmail(String email) throws Exception {
        try (CrudRepository<Admin, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("email", email);
            return repository.executeQuery("Admin.FindByEmail", params, Admin.class);
        }
    }
    public Admin fideByNationalCode(String nationalCode) throws Exception {
        try (CrudRepository<Admin, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("nationalCode", nationalCode+ "%");
            List<Admin> result = repository.executeQuery("FideByNationalCode", params, Admin.class);
            if (result.isEmpty()) {
                return null;
            } else {
                return result.get(0);
            }
        }}
    public Admin findByPhoneNumber(String phoneNumber) throws Exception {
        try (CrudRepository<Admin, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("phoneNumber", phoneNumber);
            List<Admin> result = repository.executeQuery("Admin.FindByPhoneNumber", params, Admin.class);
            if (result.isEmpty()) {
                return null;
            } else {
                return result.get(0);
            }
        }
    }
}




