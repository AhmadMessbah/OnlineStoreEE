package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.Address;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressService {
    @Getter
    private static AddressService service = new AddressService();

    private AddressService() {
    }

    public Address save(Address address) throws Exception {
        try (CrudRepository<Address, Long> repository = new CrudRepository()) {
            return repository.save(address);
        }
    }


    public Address edit(Address address) throws Exception {
        try (CrudRepository<Address, Long> repository = new CrudRepository()) {
            return repository.edit(address);
        }
    }

    public Address remove(Long id) throws Exception {
        try (CrudRepository<Address, Long> repository = new CrudRepository()) {
            return repository.remove(id, Address.class);
        }
    }

    public List<Address> findAll() throws Exception {
        try (CrudRepository<Address, Long> repository = new CrudRepository()) {
            return repository.findAll(Address.class);
        }
    }

    public Address findById(Long id) throws Exception {
        try (CrudRepository<Address, Long> repository = new CrudRepository()) {
            return repository.findById(id, Address.class);
        }
    }

    public Address findByPostalCode(String postalCode) throws Exception {
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

    public List<Address> findByCountryAndState(String countryName, String stateName) throws Exception {
        try (CrudRepository<Address, Long> repository = new CrudRepository()) {
            Map<String, Object> param = new HashMap<>();
            param.put("countryName", countryName);
            param.put("stateName", stateName);
            return repository.executeQuery("Address.FindByCountryAndState", param, Address.class);
        }
    }

//    todo : findByCity, findByText
}


