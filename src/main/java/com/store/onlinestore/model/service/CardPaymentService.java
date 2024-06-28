package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.CardPayment;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardPaymentService {

    @Getter
    private static CardPaymentService service = new CardPaymentService();

    private CardPaymentService() {
    }

    public CardPayment save(CardPayment CardPayment)  throws Exception {
        try (CrudRepository<CardPayment, Long> repository = new CrudRepository<>()) {
            return repository.save(CardPayment);
        }
    }

    public CardPayment edit(CardPayment cardPayment) throws Exception {
        try (CrudRepository<CardPayment, Long> repository = new CrudRepository<>()) {
            return repository.edit(cardPayment);
        }
    }

    public CardPayment remove(Long id) throws Exception {
        try (CrudRepository<CardPayment, Long> repository = new CrudRepository<>()) {
            return repository.remove(id, CardPayment.class);
        }
    }

    public List<CardPayment> findAll() throws Exception {
        try (CrudRepository<CardPayment, Long> repository = new CrudRepository<>()) {
            return repository.findAll(CardPayment.class);
        }
    }

    public CardPayment findById(Long id) throws Exception {
        try (CrudRepository<CardPayment, Long> repository = new CrudRepository<>()) {
            return repository.findById(id, CardPayment.class);
        }
    }

    public CardPayment FindByCardNumber(long cardNumber) throws Exception {
        try (CrudRepository<CardPayment, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("cardNumber", cardNumber);
            List<CardPayment> result = repository.executeQuery( "Card.FindByCardNumber", params, CardPayment.class);
            if (result.isEmpty()) {
                return null;
            } else {
                return result.get(0);
            }
        }
    }

    public CardPayment FindByDateTime(LocalDateTime dateTime) throws Exception {
        try (CrudRepository<CardPayment, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("DateTime", dateTime);
            List<CardPayment> result = repository.executeQuery( "Check.FindByDateTime", params, CardPayment.class);
            if (result.isEmpty()) {
                return null;
            } else {
                return result.get(0);
            }
        }
    }
}

