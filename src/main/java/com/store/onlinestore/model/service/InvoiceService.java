package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.Invoice;
import com.store.onlinestore.model.entity.Product;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class InvoiceService implements Serializable {
    @PersistenceContext(unitName = "store")
    private EntityManager entityManager;

    public Invoice save(Invoice invoice) throws Exception {
        entityManager.persist(invoice);
        return invoice;
    }

    public Invoice edit(Invoice invoice) throws Exception {
        Invoice foundInvoice = entityManager.find(Invoice.class, invoice.getId());
        if (foundInvoice != null) {
            entityManager.merge(invoice);
        }
        return invoice;
    }

    public Invoice remove(Long id) throws Exception {
        Invoice invoice = entityManager.find(Invoice.class, id);
        if (invoice != null) {
            invoice.setDeleted(true);
            entityManager.merge(invoice);
        }
        return invoice;
    }

    public List<Invoice> findAll() throws Exception {
        return entityManager
                .createQuery("select i from invoiceEntity i where i.deleted=false", Invoice.class)
                .getResultList();
    }

    public Invoice findById(Long id) throws Exception {
        Invoice invoice = entityManager.find(Invoice.class, id);
        return invoice;
    }

    public Invoice findBySerial(String serial) throws Exception {
        return entityManager
                .createQuery("select i from invoiceEntity i where i.serial =:serial", Invoice.class)
                .setParameter("serial", serial)
                .getSingleResult();
    }


    public List<Invoice> findByCustomerId(Long customerId) throws Exception {
        return entityManager
                .createQuery("select i from invoiceEntity i where i.customer.id = :customerId", Invoice.class)
                .setParameter("customerId", customerId)
                .getResultList();
    }

//  todo :  findByNameAndFamily

    public List<Invoice> findByDate(LocalDateTime localDateTime) throws Exception {
        return entityManager
                .createQuery("select  i from invoiceEntity i where  i.localDateTime = :localDateTime", Invoice.class)
                .setParameter("localDateTime", localDateTime)
                .getResultList();
    }

    public List<Invoice> findByRangeDate(LocalDateTime startDate, LocalDateTime endDate) throws Exception {
        return entityManager
                .createQuery("select  i from invoiceEntity i where  i.localDateTime between :startTime and :endTime", Invoice.class)
                .setParameter("startTime", startDate)
                .setParameter("endTime", endDate)
                .getResultList();
    }
}

