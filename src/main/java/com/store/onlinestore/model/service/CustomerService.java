package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.Customer;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService {
    @Getter
    private static CustomerService service = new CustomerService();

    private CustomerService() {
    }

    public Customer save(Customer customer) throws Exception {
        try (CrudRepository<Customer, Long> repository = new CrudRepository<>()) {
            return repository.save(customer);
        }
    }

    public Customer edit(Customer customer) throws Exception {
        try (CrudRepository<Customer, Long> repository = new CrudRepository<>()) {
            return repository.edit(customer);
        }
    }

    public Customer remove(Long id) throws Exception {
        try (CrudRepository<Customer, Long> repository = new CrudRepository<>()) {
            return repository.remove(id, Customer.class);
        }
    }

    public List<Customer> findAll() throws Exception {
        try (CrudRepository<Customer, Long> repository = new CrudRepository<>()) {
            return repository.findAll(Customer.class);
        }
    }

    public Customer findById(Long id) throws Exception {
        try (CrudRepository<Customer, Long> repository = new CrudRepository<>()) {
            return repository.findById(id, Customer.class);
        }
    }

    public List<Customer> findByUsername(String username) throws Exception {
        try (CrudRepository<Customer, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("username", username+"%");
            return repository.executeQuery("Customer.FindByUsername", params, Customer.class);
        }
    }

    public List<Customer> findByUsernameAndPassword(String username, String password) throws Exception {
        try (CrudRepository<Customer, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("username", username+"%");
            params.put("password", password+"%");
            return repository.executeQuery("Customer.FindByUsernameAndPassword", params, Customer.class);
        }
    }
}
