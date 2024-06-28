package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.Delivery;
import com.store.onlinestore.model.entity.enums.DeliveryStatus;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeliveryService {
    @Getter
    private static DeliveryService deliveryService = new DeliveryService();

    private DeliveryService() {
    }

    public Delivery deliverySave(Delivery delivery) throws Exception {
        try (CrudRepository<Delivery, Long> repository = new CrudRepository<>()) {
            return repository.save(delivery);
        }
    }

    public Delivery deliveryEdit(Delivery delivery) throws Exception {
        try (CrudRepository<Delivery, Long> repository = new CrudRepository<>()) {
            return repository.edit(delivery);
        }
    }

    public Delivery deliveryRemove(Long id) throws Exception {
        try (CrudRepository<Delivery, Long> repository = new CrudRepository()) {
            return repository.remove(id, Delivery.class);
        }
    }

    public List<Delivery> deliveryFindAll() throws Exception {
        try (CrudRepository<Delivery, Long> repository = new CrudRepository<>()) {
            return repository.findAll(Delivery.class);
        }
    }

    public Delivery deliveryFindById(Long id) throws Exception {
        try (CrudRepository<Delivery, Long> repository = new CrudRepository<>()) {
            return repository.findById(id, Delivery.class);
        }
    }

    public Delivery deliveryFindByOrderId(String orderId) throws Exception {
        try (CrudRepository<Delivery, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("orderId", orderId);
            List<Delivery> result = repository.executeQuery("Delivery.FindByOrderId", params, Delivery.class);
            if (!result.isEmpty()) {
                return result.get(0);
            } else {
                return null;
            }
        }
    }

//todo: Dar Class Invoice Bayad FindByNameAndFamily tarif beshe

//    public List<Delivery> deliveryFindByNameAndFamily(String name, String family) throws Exception {
//        InvoiceService.getService().
//    }

    public List<Delivery> deliveryFindByReceiverName(String receiverName) throws Exception {
        try (CrudRepository<Delivery, Object> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("receiverName", receiverName);
            return repository.executeQuery("Delivery.FindByReceiverName", params, Delivery.class);
        }
    }

    public List<Delivery> deliveryFindByDeliveryStatus(DeliveryStatus status) throws Exception {
        try (CrudRepository<Delivery, Object> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("deliveryStatus", status);
            return repository.executeQuery("Delivery.FindByDeliveryStatus", params, Delivery.class);
        }
    }

}