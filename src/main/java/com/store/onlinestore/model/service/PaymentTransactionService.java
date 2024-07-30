package com.store.onlinestore.model.service;

import com.store.onlinestore.controller.exception.PaymentTransactionNotFoundException;
import com.store.onlinestore.model.entity.Base;
import com.store.onlinestore.model.entity.Invoice;
import com.store.onlinestore.model.entity.PaymentTransaction;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.Getter;

import java.util.List;

@ApplicationScoped
public class PaymentTransactionService extends Base {
    @PersistenceContext(unitName = "store")
    private EntityManager entityManager;

    public PaymentTransaction save(PaymentTransaction paymentTransaction) throws Exception {
        entityManager.persist(paymentTransaction);
        return paymentTransaction;
    }

    public PaymentTransaction edit(PaymentTransaction paymentTransaction) throws Exception {
        PaymentTransaction foundPaymentTransaction = entityManager.find(PaymentTransaction.class, paymentTransaction.getId());
        if (foundPaymentTransaction != null) {
            entityManager.merge(paymentTransaction);
        }
        return paymentTransaction;
    }

    public PaymentTransaction remove(Long id) throws Exception {
        PaymentTransaction paymentTransaction = entityManager.find(PaymentTransaction.class, id);
        if (paymentTransaction != null) {
            paymentTransaction.setDeleted(true);
            entityManager.merge(paymentTransaction);
        }
        return paymentTransaction;
    }

    @Transactional
    public List<PaymentTransaction> findAll() throws Exception {
        return entityManager
                .createQuery("select p from paymentTransactionEntity p where p.deleted=false", PaymentTransaction.class)
                .getResultList();
    }

    @Transactional
    public PaymentTransaction findById(Long id) throws Exception {
        PaymentTransaction paymentTransaction = entityManager.find(PaymentTransaction.class, id);
        return paymentTransaction;
    }
}

