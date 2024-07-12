package com.store.onlinestore.model.service;


import com.store.onlinestore.model.entity.InvoiceItem;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.Serializable;
import java.util.List;

@ApplicationScoped
public class InvoiceItemService implements Serializable {

    @PersistenceContext(unitName = "store")
    private EntityManager entityManager;

    private InvoiceItemService() {
    }

    public InvoiceItem save(InvoiceItem invoiceItem) throws Exception {
        entityManager.persist(invoiceItem);
        return invoiceItem;
    }

    public InvoiceItem edit(InvoiceItem invoiceItem) throws Exception {
        InvoiceItem foundinvoiceItem = entityManager.find(InvoiceItem.class, invoiceItem.getId());
        if (foundinvoiceItem != null) {
            entityManager.merge(invoiceItem);
        }
        return invoiceItem;
    }

    //    todo : convert to logical remove
    public InvoiceItem remove(Long id) throws Exception {
        InvoiceItem invoiceItem = entityManager.find(InvoiceItem.class, id);
        if (invoiceItem != null) {
            invoiceItem.setDeleted(true);
            entityManager.merge(invoiceItem);
        }
        return invoiceItem;
    }

    public List<InvoiceItem> findAll() throws Exception {
        return entityManager
                .createQuery("select ii from invoiceItemEntity ii where ii.deleted=false", InvoiceItem.class)
                .getResultList();
    }

    public InvoiceItem findById(Long id) throws Exception {
        InvoiceItem invoiceItem = entityManager.find(InvoiceItem.class, id);
        return invoiceItem;
    }


}
