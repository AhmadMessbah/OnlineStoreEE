package com.store.onlinestore.model.service;

import com.store.onlinestore.model.entity.Invoice;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class InvoiceService {
    @PersistenceContext(unitName = "store")
    private EntityManager entityManager;

    @Transactional
    public Invoice save(Invoice invoice) throws Exception {
        entityManager.persist(invoice);
        return invoice;
    }

    @Transactional
    public Invoice edit(Invoice invoice) throws Exception {
        Invoice foundInvoice = entityManager.find(Invoice.class, invoice.getId());
        if (foundInvoice != null) {
            entityManager.merge(invoice);
        }
        return invoice;
    }

    @Transactional
    public Invoice remove(Long id) throws Exception {
        Invoice invoice = entityManager.find(Invoice.class, id);
        if (invoice != null) {
            invoice.setDeleted(true);
            entityManager.merge(invoice);
        }
        return invoice;
    }

    @Transactional
    public List<Invoice> findAll() throws Exception {
        return entityManager
                .createQuery("select i from invoiceEntity i where i.deleted=false", Invoice.class)
                .getResultList();
    }

    @Transactional
    public Invoice findById(Long id) throws Exception {
        return entityManager.find(Invoice.class, id);
    }

    @Transactional
    public Invoice findBySerial(String serial) throws Exception {
        return entityManager
                .createQuery("select i from invoiceEntity i where i.serial =:serial", Invoice.class)
                .setParameter("serial", serial)
                .getSingleResult();
    }


    @Transactional
    public List<Invoice> findByCustomerId(Long customerId) throws Exception {
        return entityManager
                .createQuery("select i from invoiceEntity i where i.customer.id = :customerId", Invoice.class)
                .setParameter("customerId", customerId)
                .getResultList();
    }

//  todo :  findByNameAndFamily

    @Transactional
    public List<Invoice> findByDate(LocalDateTime localDateTime) throws Exception {
        return entityManager
                .createQuery("select  i from invoiceEntity i where  i.localDateTime = :localDateTime", Invoice.class)
                .setParameter("localDateTime", localDateTime)
                .getResultList();
    }

    @Transactional
    public List<Invoice> findByRangeDate(LocalDateTime startDate, LocalDateTime endDate) throws Exception {
        return entityManager
                .createQuery("select  i from invoiceEntity i where  i.localDateTime between :startTime and :endTime", Invoice.class)
                .setParameter("startTime", startDate)
                .setParameter("endTime", endDate)
                .getResultList();
    }
}

