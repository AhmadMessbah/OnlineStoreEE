package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.Address;
import com.store.onlinestore.model.repository.CrudRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressService {
    private static AddressService service = new AddressService();

    private AddressService() {
    }

    public Address addressSave(Address address) throws Exception {
        try (CrudRepository<Address, Long> repository = new CrudRepository()) {
            return repository.save(address);
        }
    }


    public Address addressEdit(Address address) throws Exception {
        try (CrudRepository<Address, Long> repository = new CrudRepository()) {
            return repository.edit(address);
        }
    }

    public Address addressRemove(Long id) throws Exception {
        try (CrudRepository<Address, Long> repository = new CrudRepository()) {
            return repository.remove(id, Address.class);
        }
    }

    public List<Address> addressFindAll() throws Exception {
        try (CrudRepository<Address, Long> repository = new CrudRepository()) {
            return repository.findAll(Address.class);
        }
    }

    public Address addressFindById(Long id) throws Exception {
        try (CrudRepository<Address, Long> repository = new CrudRepository()) {
            return repository.findById(id, Address.class);
        }
    }

    public Address addressFindByPostalCode(String postalCode) throws Exception {
        try (CrudRepository<Address, Long> repository = new CrudRepository()) {
            Map<String, Object> param = new HashMap<>();
            param.put("postalCode", postalCode);
            List<Address> addressList = repository.executeQuery("Address.FindByPostalCode", param, Address.class);
            if (addressList.isEmpty()) {
                return addressList.get(0);
            } else {
                return null;
            }
        }
    }

    public List<Address> addressFindByCountryAndState(String countryName, String stateName) throws Exception {
        try (CrudRepository<Address, Long> repository = new CrudRepository()) {
            Map<String, Object> param = new HashMap<>();
            param.put("countryName", countryName);
            param.put("stateName", stateName);
            return repository.executeQuery("Address.FindByCountryAndState", param, Address.class);
        }
    }
}


