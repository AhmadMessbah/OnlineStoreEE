package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.Person;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonService {
    @Getter
    private static PersonService service = new PersonService();

    private PersonService() {
    }

    public Person save(Person person) throws Exception {
        try (CrudRepository<Person, Long> repository = new CrudRepository<>()) {
            return repository.save(person);
        }
    }

    public Person edit(Person person) throws Exception {
        try (CrudRepository<Person, Long> repository = new CrudRepository<>()) {
            return repository.edit(person);
        }
    }

    //    todo : convert to logical remove
    public Person remove(Long id) throws Exception {
        try (CrudRepository<Person, Long> repository = new CrudRepository<>()) {
            return repository.remove(id, Person.class);
        }
    }

    public List<Person> findAll() throws Exception {
        try (CrudRepository<Person, Long> repository = new CrudRepository<>()) {
            return repository.findAll(Person.class);
        }
    }

    public Person findById(Long id) throws Exception {
        try (CrudRepository<Person, Long> repository = new CrudRepository<>()) {
            return repository.findById(id, Person.class);
        }
    }

    public List<Person> findByNameAndFamily(String name, String family) throws Exception {
        try (CrudRepository<Person, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("name", name+"%");
            params.put("family", family+"%");
            return repository.executeQuery("Person.FindByNameAndFamily", params, Person.class);
        }
    }

    public Person findByPhoneNumber(String phoneNumber) throws Exception {
        try (CrudRepository<Person, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("phoneNumber", phoneNumber);
            List<Person> result = repository.executeQuery("Person.FindByPhoneNumber", params, Person.class);
            if (result.isEmpty()) {
                return null;
            } else {
                return result.get(0);
            }
        }
    }
}
