package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.Inventory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public class InventoryService {
    @PersistenceContext(unitName = "store")
    private EntityManager entityManager;

    public Inventory save(Inventory inventory) throws Exception {
        entityManager.persist(inventory);
        return inventory;
    }

    public Inventory edit(Inventory inventory) throws Exception {
        Inventory findInventory = entityManager.find(Inventory.class, inventory.getId());
        if (findInventory != null) {
            entityManager.merge(inventory);
        }
        return inventory;
    }

    public Inventory remove(Long id) throws Exception {
        Inventory inventory = entityManager.find(Inventory.class, id);
        if (inventory != null) {
            inventory.setDeleted(true);
            entityManager.merge(inventory);
        }
        return inventory;
    }

    public List<Inventory> findAll() throws Exception {
        return entityManager.createQuery("select oo from inventoryEntity oo where oo.deleted=false", Inventory.class).getResultList();
    }

    public Inventory findById(Long id) throws Exception {
        Inventory inventory = entityManager.find(Inventory.class, id);
        return inventory;
    }


    public List<Inventory> findByProductID(Long productId) throws Exception {
        return entityManager.createQuery("select oo from inventoryEntity oo where oo.product=:product", Inventory.class)
                .setParameter("product", productId)
                .getResultList();
    }

    public Inventory findByInventoryName(String inventoryName) throws Exception {
        return entityManager.createQuery("select oo from inventoryEntity oo where oo.name like :name", Inventory.class)
                .setParameter("name", inventoryName + "%")
                .getSingleResult();
    }

    public Inventory findByLocation(String location) throws Exception {
        return entityManager.createQuery("select oo from inventoryEntity oo where oo.loction=:location", Inventory.class)
                .setParameter("location", location)
                .getSingleResult();
    }

    public Inventory findBySupplier(String supplier) throws Exception {
        return entityManager.createQuery("select oo from inventoryEntity oo where oo.supplierList=:supplier", Inventory.class)
                .setParameter("supplier", supplier)
                .getSingleResult();
    }
}
