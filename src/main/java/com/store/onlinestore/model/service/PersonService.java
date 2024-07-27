package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.Person;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class PersonService {
    @PersistenceContext(unitName = "store")
    private EntityManager entityManager;

    @Transactional
    public Person save(Person person) throws Exception {
        entityManager.persist(person);
        return person;
    }

    @Transactional
    public Person edit(Person person) throws Exception {
        Person foundPerson = entityManager.find(Person.class, person.getId());
        if (foundPerson != null) {
            entityManager.merge(person);
        }
        return person;
    }

    @Transactional
    public Person remove(Long id) throws Exception {
        Person person = entityManager.find(Person.class, id);
        if (person != null) {
            person.setDeleted(true);
            entityManager.merge(person);
        }
        return person;
    }

    @Transactional
    public List<Person> findAll() throws Exception {
        return entityManager
                .createQuery("select oo from personEntity oo where oo.deleted=false", Person.class)
                .getResultList();
    }

    @Transactional
    public Person findById(Long id) throws Exception {
        return entityManager.find(Person.class, id);
    }

    @Transactional
    public List<Person> findByNameAndFamily(String name, String family) throws Exception {
        return entityManager
                .createQuery("select p from personEntity p where p.name like :name and p.family like :family", Person.class)
                .setParameter("name", name + "%")
                .setParameter("family", family + "%")
                .getResultList();
    }

    @Transactional
    public Person findByPhoneNumber(String phoneNumber) throws Exception {
        return entityManager
                .createQuery("select p from personEntity p where p.phoneNumber =:phoneNumber", Person.class)
                .setParameter("phoneNumber", phoneNumber)
                .getSingleResult();
    }
}
