package com.store.onlinestore.model.service;

import com.store.onlinestore.controller.exception.CustomerNotFoundException;
import com.store.onlinestore.model.entity.Admin;
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
            customer.setRole(RoleService.getService().FindByRole("customer"));
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
            Customer customer = repository.findById(id, Customer.class);
            if (customer != null) {
                return customer;
            }
            throw new CustomerNotFoundException();
        }
    }

    public List<Customer> findByUsername(String username) throws Exception {
        try (CrudRepository<Customer, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("username", username);
            return repository.executeQuery("Customer.FindByUsername", params, Customer.class);
        }
    }

    public List<Customer> findByNameAndFamily(String name, String family) throws Exception {
        try (CrudRepository<Customer, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("name", name+ "%");
            params.put("family", family + "%");
            return repository.executeQuery("Customer.FindByNameAndFamily", params, Customer.class);
        }
    }

    public List<Customer> findByUsernameAndPassword(String username, String password) throws Exception {
        try (CrudRepository<Customer, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("username", username);
            params.put("password", password);
            return repository.executeQuery("Customer.FindByUsernameAndPassword", params, Customer.class);
        }
    }

    public List<Customer> findByEmail(String email) throws Exception {
        try (CrudRepository<Customer, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("email", email+"%");
            return repository.executeQuery("Customer.FindByEmail", params, Customer.class);
        }
    }

    public Customer findByPhoneNumber(String phoneNumber) throws Exception {
        try (CrudRepository<Customer, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("phoneNumber", phoneNumber);
            List<Customer> result = repository.executeQuery("Customer.FindByPhoneNumber", params, Customer.class);
            if (result.isEmpty()) {
                return null;
            } else {
                return result.get(0);
            }
        }
    }
    public Customer fideByNationalCode(String nationalCode) throws Exception {
        try (CrudRepository<Customer, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("nationalCode", nationalCode);
            List<Customer> result = repository.executeQuery("FideByNationalCode", params, Customer.class);
            if (result.isEmpty()) {
                return null;
            } else {
                return result.get(0);
            }
        }}
}
