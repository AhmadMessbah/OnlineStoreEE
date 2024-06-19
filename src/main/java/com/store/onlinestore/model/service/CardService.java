package com.store.onlinestore.model.service;
import com.store.onlinestore.model.entity.Card;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardService {

    @Getter
    private static CardService service = new CardService();

    private CardService() {
    }

    public Card save(Card Card)  throws Exception {
        try (CrudRepository<Card, Long> repository = new CrudRepository<>()) {
            return repository.save(Card);
        }
    }

    public Card edit(Card card) throws Exception {
        try (CrudRepository<Card, Long> repository = new CrudRepository<>()) {
            return repository.edit(card);
        }
    }

    public Card remove(Long id) throws Exception {
        try (CrudRepository<Card, Long> repository = new CrudRepository<>()) {
            return repository.remove(id, Card.class);
        }
    }

    public List<Card> findAll() throws Exception {
        try (CrudRepository<Card, Long> repository = new CrudRepository<>()) {
            return repository.findAll(Card.class);
        }
    }

    public Card findById(Long id) throws Exception {
        try (CrudRepository<Card, Long> repository = new CrudRepository<>()) {
            return repository.findById(id, Card.class);
        }
    }
    public Card FindByCardNumber(long cardNumber) throws Exception {
        try (CrudRepository<Card, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("cardNumber", cardNumber);
            List<Card> result = repository.executeQuery( "Card.FindByCardNumber", params, Card.class);
            if (result.isEmpty()) {
                return null;
            } else {
                return result.get(0);
            }
        }
    }

}

