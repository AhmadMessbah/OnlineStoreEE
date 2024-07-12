package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.CashPayment;
import com.store.onlinestore.model.repository.CrudRepository;
import com.store.onlinestore.model.entity.CardPayment;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;
import java.time.LocalDateTime;
import jakarta.persistence.Id;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardPaymentService {

   @PersistenceContext(unitName = "store")
   private EntityManager entityManager;

    public CardPayment save(CardPayment cardPayment) throws Exception {
        entityManager.persist(cardPayment);
        return cardPayment;
    }

    public CardPayment edit(CardPayment cardPayment) throws Exception {
        CardPayment foundCardPayment = entityManager.find(CardPayment.class, cardPayment.getId());
        if (foundCardPayment != null) {
            entityManager.merge(cardPayment);
        }
        return cardPayment;
    }

    public CardPayment remove(Long id) throws Exception {
        CardPayment cardPayment = entityManager.find(CardPayment.class, id);
        if (cardPayment != null) {
            cardPayment.setDeleted(true);
            entityManager.merge(cardPayment);
        }
        return cardPayment;
    }

    public List<CardPayment> findAll() throws Exception {
        return entityManager
            .createQuery("select c from cardEntity c where c.deleted = false", CardPayment.class)
            .getResultList();
    }

    public CardPayment findById(Long id) throws Exception {
        CardPayment cardPayment = entityManager.find(CardPayment.class, id);
        return cardPayment;
    }

    public CardPayment FindByCardNumber(Long cardNumber) throws Exception {
        return entityManager
            .createQuery("select c from cardEntity c where c.cardNumber =: cardNumber", CardPayment.class)
            .setParameter("cardNumber", cardNumber)
            .getSingleResult();
    }

    public CardPayment FindByBankName(String bankName) throws Exception {
        return entityManager
                .createQuery("select c from cardEntity c where c.bankName =: bankName", CardPayment.class)
                .setParameter("bankName", bankName)
                .getSingleResult();
    }

    public CardPayment findByDateTime(LocalDateTime localDateTime) throws Exception {
        CardPayment cardPayment = entityManager.find(CardPayment.class, localDateTime);
        return cardPayment;
    }
}

