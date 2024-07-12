package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.CheckPayment;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

public class CheckPaymentService {

    @PersistenceContext(unitName = "store")
    private EntityManager entityManager;

    public CheckPayment save(CheckPayment checkPayment) throws Exception {
        entityManager.persist(checkPayment);
        return checkPayment;
    }

    public CheckPayment edit(CheckPayment checkPayment) throws Exception {
        CheckPayment foundCheckPayment = entityManager.find(CheckPayment.class, checkPayment.getId());
        if (foundCheckPayment != null) {
            entityManager.merge(checkPayment);
        }
        return checkPayment;
    }

    public CheckPayment remove(Long id) throws Exception {
        CheckPayment checkPayment = entityManager.find(CheckPayment.class, id);
        if (checkPayment != null) {
            checkPayment.setDeleted(true);
            entityManager.merge(checkPayment);
        }
        return checkPayment;
    }

    public List<CheckPayment> findAll() throws Exception {
        return entityManager
            .createQuery("select ch from checkEntity ch where ch.deleted = false", CheckPayment.class)
            .getResultList();
    }

    public CheckPayment findById(Long id) throws Exception {
        CheckPayment checkPayment = entityManager.find(CheckPayment.class, id);
        return checkPayment;
    }

    public CheckPayment FindByCheckNumber(long checkNumber) throws Exception {
        return entityManager
                .createQuery("select ch from checkEntity ch where ch.checkNumber =: checkNumber", CheckPayment.class)
                .setParameter("checkNumber", checkNumber)
                .getSingleResult();
    }

    public CheckPayment FindByDateTime(LocalDateTime localDateTime) throws Exception {
        CheckPayment checkPayment = entityManager.find(CheckPayment.class, localDateTime);
        return checkPayment;
    }
}
