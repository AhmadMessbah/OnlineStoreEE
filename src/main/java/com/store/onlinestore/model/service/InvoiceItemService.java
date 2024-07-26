package com.store.onlinestore.model.service;


import com.store.onlinestore.model.entity.InvoiceItem;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@ApplicationScoped
public class InvoiceItemService {
    @PersistenceContext(unitName = "store")
    private EntityManager entityManager;

    public InvoiceItem save(InvoiceItem invoiceItem) throws Exception {
            entityManager.persist(invoiceItem);
            return invoiceItem;
    }

    public InvoiceItem edit(InvoiceItem invoiceItem) throws Exception {
        InvoiceItem foundInvoiceItem = entityManager.find(InvoiceItem.class, invoiceItem.getId());
        if (foundInvoiceItem != null) {
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

    public InvoiceItem findById(Long id) throws Exception{
        InvoiceItem invoiceItem = entityManager.find(InvoiceItem.class, id);
        return invoiceItem;
    }
}
