package com.store.onlinestore.model.service;


import com.store.onlinestore.controller.exception.StockNotFoundException;

import com.store.onlinestore.model.entity.Stock;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockService {
    @Getter
    private static StockService service = new StockService();

    private StockService() {
    }

    public Stock save(Stock stock) throws Exception {
        try (CrudRepository<Stock, Long> repository = new CrudRepository<>()) {
            return repository.save(stock);
        }
    }

    public Stock edit(Stock stock) throws Exception {
        try (CrudRepository<Stock, Long> repository = new CrudRepository<>()) {
            return repository.edit(stock);
        }
    }

    public Stock remove(Long id) throws Exception {
        try (CrudRepository<Stock, Long> repository = new CrudRepository<>()) {
            if (repository.findById(id, Stock.class) != null) {
                return repository.remove(id, Stock.class);
            }
            throw new StockNotFoundException();
        }
    }

    public Stock findById(Long id) throws Exception {
        try (CrudRepository<Stock, Long> repository = new CrudRepository<>()) {
            return repository.findById(id, Stock.class);
        }
    }

    public List<Stock> findAll() throws Exception {
        try (CrudRepository<Stock, Long> repository = new CrudRepository<>()) {
            return repository.findAll(Stock.class);
        }
    }

    public List<Stock> findByStockType(String stockType) throws Exception {
        try (CrudRepository<Stock, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("stockType", stockType + "%");
            return repository.executeQuery("FindByStockType", params, Stock.class);
        }
    }

    public List<Stock> findByStockItems(String stockItems) throws Exception {
        try (CrudRepository<Stock, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("stockItems", stockItems + "%");
            return repository.executeQuery("FindByStockItems", params, Stock.class);
        }
    }
}
