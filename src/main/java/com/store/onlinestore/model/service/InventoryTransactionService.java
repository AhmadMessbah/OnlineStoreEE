package com.store.onlinestore.model.service;
import com.store.onlinestore.model.entity.InventoryTransaction;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;


public class InventoryTransactionService {
    @PersistenceContext(unitName = "store")
    private EntityManager entityManager;

    public InventoryTransaction save(InventoryTransaction inventoryTransaction) throws Exception {
        entityManager.persist(inventoryTransaction);
        return inventoryTransaction;
    }

    public InventoryTransaction edit(InventoryTransaction inventoryTransaction) throws Exception {
        InventoryTransaction findInventoryTransaction = entityManager.find(InventoryTransaction.class, inventoryTransaction.getId());
        if (findInventoryTransaction != null) {
            entityManager.merge(inventoryTransaction);
        }
        return inventoryTransaction;
    }

    public InventoryTransaction remove(Long id) throws Exception {
        InventoryTransaction inventoryTransaction = entityManager.find(InventoryTransaction.class, id);
        if (inventoryTransaction != null) {
            inventoryTransaction.setDeleted(true);
            entityManager.merge(inventoryTransaction);
        }
        return inventoryTransaction;
    }

    public List<InventoryTransaction> findAll() throws Exception {
        return entityManager.createQuery("select oo from inventoryTransactionEntity oo where oo.deleted=false", InventoryTransaction.class)
                .getResultList();
    }

    public List<InventoryTransaction> findByDeliverPerson(String name, String family) throws Exception {
        return entityManager.createQuery("select oo from inventoryTransactionEntity oo where oo.deliveryPerson.name like :deliverPersonName and oo.deliveryPerson.family like :deliverPersonFamily", InventoryTransaction.class)
                .setParameter("deliverPersonName", name)
                .setParameter("deliverPersonFamily", family)
                .getResultList();
    }

    public List<InventoryTransaction> findByReceiverPerson(String name, String family) throws Exception {
        return entityManager.createQuery("select oo from inventoryTransactionEntity oo where oo.receiverPerson.name like :receiverPersonName and oo.receiverPerson.family like :receiverPersonFamily", InventoryTransaction.class)
                .setParameter("receiverPersonName", name)
                .setParameter("receiverPersonFamily", family)
                .getResultList();
    }

    public List<InventoryTransaction> findByProductID(Long productId) throws Exception {
        return entityManager.createQuery("select oo from inventoryTransactionEntity oo where oo.productId=:productId", InventoryTransaction.class)
                .setParameter("productId", productId)
                .getResultList();
    }

    public InventoryTransaction findByRegisterDateTime(LocalDateTime registerDateTime) throws Exception {
        return entityManager.createQuery("select oo from inventoryTransactionEntity oo where oo.registerDateTime=:registerDate", InventoryTransaction.class)
                .setParameter("registerDate", registerDateTime)
                .getSingleResult();
    }

    public InventoryTransaction findByManagerNationalCode(String nationalCode) throws Exception {
        return entityManager.createQuery("select oo from inventoryTransactionEntity oo where oo.deliveryPerson.nationalCode=:nationalCode", InventoryTransaction.class)
                .setParameter("nationalCode", nationalCode)
                .getSingleResult();
    }

    public InventoryTransaction findByReceiverNationalCode(String nationalCode) throws Exception {
        return entityManager.createQuery("select oo from inventoryTransactionEntity oo where oo.receiverPerson.nationalCode=:nationalCode", InventoryTransaction.class)
                .setParameter("nationalCode", nationalCode)
                .getSingleResult();
    }
}
