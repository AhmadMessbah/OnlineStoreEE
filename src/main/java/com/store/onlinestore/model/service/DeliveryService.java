package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.Delivery;
import com.store.onlinestore.model.entity.enums.DeliveryMethod;
import com.store.onlinestore.model.entity.enums.DeliveryStatus;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class DeliveryService {
    @PersistenceContext(unitName = "store")
    private EntityManager entityManager;

    @Transactional
    public Delivery save(Delivery delivery) throws Exception {
        entityManager.persist(delivery);
        return delivery;
    }


    @Transactional
    public Delivery edit(Delivery delivery) throws Exception {
        Delivery foundDelivery = entityManager.find(Delivery.class, delivery.getId());
        if (foundDelivery != null) {
            entityManager.merge(delivery);
        }
        return delivery;
    }

    @Transactional
    public Delivery remove(Long id) throws Exception {
        Delivery delivery = entityManager.find(Delivery.class, id);
        if (delivery != null) {
            delivery.setDeleted(true);
            entityManager.merge(delivery);
        }
        return delivery;
    }

    @Transactional
    public List<Delivery> findAll() throws Exception {
        return entityManager
                .createQuery("select d from deliveryEntity d where d.deleted=false", Delivery.class)
                .getResultList();
    }

    @Transactional
    public Delivery findById(Long id) throws Exception {
        Delivery delivery = entityManager.find(Delivery.class, id);
        return delivery;
    }

    @Transactional
    public Delivery findByOrderId(String orderId) throws Exception {
        return entityManager
                .createQuery("select d from deliveryEntity d where d.orderId =:orderId", Delivery.class)
                .setParameter("orderId", orderId)
                .getSingleResult();
    }

//todo: Dar Class Invoice Bayad FindByNameAndFamily tarif beshe

//    public List<Delivery> deliveryFindByNameAndFamily(String name, String family) throws Exception {
//        InvoiceService.getService().
//    }

    public List<Delivery> findByReceiverName(String receiverName) throws Exception {
        return entityManager
                .createQuery("select d from deliveryEntity d where d.receiverName =:receiverName", Delivery.class)
                .setParameter("receiverName", receiverName)
                .getResultList();
    }

    public List<Delivery> findByDeliveryStatus(DeliveryStatus deliveryStatus) throws Exception {
        return entityManager
                .createQuery("select d from deliveryEntity d where d.deliveryStatus =:deliveryStatus", Delivery.class)
                .setParameter("deliveryStatus", deliveryStatus)
                .getResultList();
    }

    public List<Delivery> findByDeliveryMethod(DeliveryMethod deliveryMethod) throws Exception {
        return entityManager
                .createQuery("select d from deliveryEntity d where d.deliveryMethod =:deliveryMethod", Delivery.class)
                .setParameter("deliveryMethod", deliveryMethod)
                .getResultList();
    }

// todo : Aya In Do Mored Paiin Dorost Hast ?

//    public List<Delivery> findByAddress(Address address) throws Exception {
//        try (CrudRepository<Delivery, Object> repository = new CrudRepository<>()) {
//            Map<String, Object> params = new HashMap<>();
//            params.put("address", address);
//            return repository.executeQuery("Delivery.FindByAddress", params, Delivery.class);
//        }
//    }
//
//    public List<Delivery> findByAddress(String postalCode) throws Exception {
//        try (CrudRepository<Delivery, Object> repository = new CrudRepository<>()) {
//            Address addressFound = AddressService.getService().findByPostalCode(postalCode);
//            if (addressFound != null) {
//                Map<String, Object> params = new HashMap<>();
//                params.put("address", addressFound);
//                return repository.executeQuery("Delivery.FindByAddress", params, Delivery.class);
//            } else {
//                return null;
//            }
//        }
//    }
}