package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

public class PersonService {
    @PersistenceContext(unitName = "store")
    private EntityManager entityManager;

    public Person save(Person person) throws Exception {
        entityManager.persist(person);
        return person;
    }

    public Person edit(Person person) throws Exception {
        Person foundPerson = entityManager.find(Person.class, person.getId());
        if (foundPerson != null) {
            entityManager.merge(person);
        }
        return person;
    }

    public Person remove(Long id) throws Exception {
        Person person = entityManager.find(Person.class, id);
        if (person != null) {
            person.setDeleted(true);
            entityManager.merge(person);
        }
        return person;
    }

    public List<Person> findAll() throws Exception {
        return entityManager
                .createQuery("select oo from personEntity oo where oo.deleted=false", Person.class)
                .getResultList();
    }

    public Person findById(Long id) throws Exception {
        Person person = entityManager.find(Person.class, id);
        return person;
    }

    public List<Person> findByNameAndFamily(String name, String family) throws Exception {
        return entityManager
                .createQuery("select p from personEntity p where p.name like :name and p.family like :family", Person.class)
                .setParameter("name", name + "%")
                .setParameter("family", family + "%")
                .getResultList();
    }

    public Person findByPhoneNumber(String phoneNumber) throws Exception {
        return entityManager
                .createQuery("select p from personEntity p where p.phoneNumber =:phoneNumber", Person.class)
                .setParameter("phoneNumber", phoneNumber)
                .getSingleResult();
    }
}
