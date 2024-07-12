package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.CashPayment;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

public class CashPaymentService {

    @PersistenceContext(unitName = "store")
    private EntityManager entityManager;

    public CashPayment save(CashPayment cashPayment) throws Exception {
        entityManager.persist(cashPayment);
        return cashPayment;
    }

    public CashPayment edit(CashPayment cashPayment) throws Exception {
        CashPayment foundCashPayment = entityManager.find(CashPayment.class, cashPayment.getId());
        if (foundCashPayment != null) {
            entityManager.merge(cashPayment);
        }
        return cashPayment;
    }

    public CashPayment remove(Long id) throws Exception {
        CashPayment cashPayment = entityManager.find(CashPayment.class, id);
        if (cashPayment != null) {
            cashPayment.setDeleted(true);
            entityManager.merge(cashPayment);
        }
        return cashPayment;
    }

    public List<CashPayment> findAll() throws Exception {
        return entityManager
                .createQuery("select c from cashEntity c where c.deleted = false", CashPayment.class)
                .getResultList();
    }

    public CashPayment findById(Long id) throws Exception {
        CashPayment cashPayment = entityManager.find(CashPayment.class, id);
        return cashPayment;
    }

    public CashPayment findByDateTime(LocalDateTime localDateTime) throws Exception {
        CashPayment cashPayment = entityManager.find(CashPayment.class, localDateTime);
        return cashPayment;
    }
}

