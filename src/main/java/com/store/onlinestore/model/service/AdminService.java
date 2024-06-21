package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.Admin;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;

import java.util.List;

public class AdminService {
    @Getter
    private static AdminService service = new AdminService();

    private AdminService() {}

    public Admin save(Admin admin) throws Exception {
        try (CrudRepository<Admin, Long> repository = new CrudRepository<>()) {
            return repository.save(admin);
        }
    }

    public Admin edit(Admin admin) throws Exception {
        try (CrudRepository<Admin, Long> repository = new CrudRepository<>()) {
            return repository.edit(admin);
        }
    }

    //    todo : convert to logical remove
    public Admin remove(Long id) throws Exception {
        try (CrudRepository<Admin, Long> repository = new CrudRepository<>()) {
            return repository.remove(id, Admin.class);
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


}

