package com.store.onlinestore.model.service;


import com.store.onlinestore.model.entity.Manager;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;

import jakarta.persistence.PersistenceContext;

import java.util.List;

@Singleton
public class ManagerService {
    @PersistenceContext(unitName = "store")
    private EntityManager entityManager;


    public Manager save(Manager manager) throws Exception {
        entityManager.persist(manager);
   return manager;
    }

    public Manager edit(Manager manager) throws Exception {
        Manager foundManager = entityManager.find(Manager.class, manager.getId());
        if (foundManager != null) {
            entityManager.merge(manager);
        }
        return manager;
    }


    public Manager remove(Long id) throws Exception {
    Manager manager=entityManager.find(Manager.class, id);
   if(manager!=null){
       manager.setDeleted(true);
       entityManager.merge(manager);
   }
   return manager;
    }

    public List<Manager> findAll() throws Exception {
        return entityManager
                .createQuery("select n from managerEntity n where n .deleted=false", Manager.class)
                .getResultList();
    }
    public Manager findById(Long id) throws Exception {
        Manager manager=entityManager.find(Manager.class,id);
        return manager;
    }

    public List<Manager> findByEmail(String email) throws Exception {
        return entityManager
        .createQuery("select o from managerEntity o where o.email like :email",Manager.class)
                .setParameter("email",email)
                .getResultList();
    }

    public Manager findByPhoneNumber(String phoneNumber) throws Exception {
        return entityManager
                .createQuery("select o from managerEntity o where o.phoneNumber =:phoneNumber", Manager.class)
                .setParameter("phoneNumber", phoneNumber)
                .getSingleResult();
    }

        public Manager fideByNationalCode(String nationalCode) throws Exception {
            return entityManager
                    .createQuery("select o from managerEntity o where o.nationalCode=:nationalCode", Manager.class)
                    .setParameter("nationalCode", nationalCode)
                    .getSingleResult();
        }
}
