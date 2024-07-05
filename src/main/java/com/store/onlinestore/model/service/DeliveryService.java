package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.Address;
import com.store.onlinestore.model.entity.Delivery;
import com.store.onlinestore.model.entity.enums.DeliveryMethod;
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

    public Delivery save(Delivery delivery) throws Exception {
        try (CrudRepository<Delivery, Long> repository = new CrudRepository<>()) {
            return repository.save(delivery);
        }
    }

    public Delivery edit(Delivery delivery) throws Exception {
        try (CrudRepository<Delivery, Long> repository = new CrudRepository<>()) {
            return repository.edit(delivery);
        }
    }

    public Delivery remove(Long id) throws Exception {
        try (CrudRepository<Delivery, Long> repository = new CrudRepository()) {
            return repository.remove(id, Delivery.class);
        }
    }

    public List<Delivery> findAll() throws Exception {
        try (CrudRepository<Delivery, Long> repository = new CrudRepository<>()) {
            return repository.findAll(Delivery.class);
        }
    }

    public Delivery findById(Long id) throws Exception {
        try (CrudRepository<Delivery, Long> repository = new CrudRepository<>()) {
            return repository.findById(id, Delivery.class);
        }
    }

    public Delivery findByOrderId(String orderId) throws Exception {
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

    public List<Delivery> findByReceiverName(String receiverName) throws Exception {
        try (CrudRepository<Delivery, Object> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("receiverName", receiverName);
            return repository.executeQuery("Delivery.FindByReceiverName", params, Delivery.class);
        }
    }

    public List<Delivery> findByDeliveryStatus(DeliveryStatus status) throws Exception {
        try (CrudRepository<Delivery, Object> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("deliveryStatus", status);
            return repository.executeQuery("Delivery.FindByDeliveryStatus", params, Delivery.class);
        }
    }
    public  List<Delivery> findByDeliveryMethod (DeliveryMethod deliveryMethod) throws Exception{
        try (CrudRepository<Delivery, Object> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("deliveryMethod", deliveryMethod);
            return repository.executeQuery("Delivery.FindByDeliveryMethod", params, Delivery.class);
        }
    }

// todo : Aya In Do Mored Paiin Dorost Hast ?

        public List<Delivery> findByAddress(Address address) throws Exception {
        try (CrudRepository<Delivery, Object> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("address", address);
            return repository.executeQuery("Delivery.FindByAddress", params, Delivery.class);
        }
    }

    public List<Delivery> findByAddress(String postalCode) throws Exception {
        try (CrudRepository<Delivery, Object> repository = new CrudRepository<>()) {
           Address addressFound =AddressService.getService().findByPostalCode(postalCode);
           if (addressFound != null){
               Map<String, Object> params = new HashMap<>();
               params.put("address", addressFound);
               return repository.executeQuery("Delivery.FindByAddress", params, Delivery.class);
           }else {
                return null;
           }
        }
    }
}