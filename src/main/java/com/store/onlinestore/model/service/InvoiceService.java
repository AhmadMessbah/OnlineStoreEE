package com.store.onlinestore.model.service;

import com.store.onlinestore.controller.exception.InvoiceNotFoundException;
import com.store.onlinestore.model.entity.Invoice;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoiceService {
    @Getter
    private static InvoiceService service = new InvoiceService();

    private InvoiceService() {
    }

    public Invoice save(Invoice invoice) throws Exception {
        try (CrudRepository<Invoice, Long> repository = new CrudRepository<>()) {
            return repository.save(invoice);
        }
    }

    public Invoice edit(Invoice invoice) throws Exception {
        try (CrudRepository<Invoice, Long> repository = new CrudRepository<>()) {
            if (repository.findById(invoice.getId(), Invoice.class) != null) {
                return repository.edit(invoice);
            }
            throw new InvoiceNotFoundException();
        }
    }

    public Invoice remove(Long id) throws Exception {
        try (CrudRepository<Invoice, Long> repository = new CrudRepository<>()) {
            if (repository.findById(id, Invoice.class) != null) {
                return repository.remove(id, Invoice.class);
            }
            throw new InvoiceNotFoundException();
        }
    }

    public List<Invoice> findAll() throws Exception {
        try (CrudRepository<Invoice, Long> repository = new CrudRepository<>()) {
            List<Invoice> invoiceList = repository.findAll(Invoice.class);
            if (!invoiceList.isEmpty()) {
                return invoiceList;
            }
            throw new InvoiceNotFoundException();

        }
    }

    public Invoice findById(Long id) throws Exception {
        try (CrudRepository<Invoice, Long> repository = new CrudRepository<>()) {
            Invoice invoice = repository.findById(id, Invoice.class);
            if (invoice != null) {
                return invoice;
            }
            throw new InvoiceNotFoundException();
        }
    }

    public Invoice findBySerial(String serial) throws Exception {
        try (CrudRepository<Invoice, String> repository = new CrudRepository<>()) {
            Invoice invoice = repository.findById(serial, Invoice.class);
            if (invoice != null) {
                return invoice;
            }
            throw new InvoiceNotFoundException();
        }
    }

    public List<Invoice> findByCustomer(Long customerId) throws Exception {
        try (CrudRepository<Invoice, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("customerId", customerId);
            List<Invoice> invoiceList = repository.executeQuery("Invoice.FindByCustomer", params, Invoice.class);
            if (!invoiceList.isEmpty()) {
                return invoiceList;
            }
            throw new InvoiceNotFoundException();
        }
    }

    public List<Invoice> findByDate(LocalDateTime localDateTime) throws Exception {
        try (CrudRepository<Invoice, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("localDateTime", localDateTime);
            List<Invoice> invoiceList = repository.executeQuery("Invoice.FindByDate", params, Invoice.class);
            if (!invoiceList.isEmpty()) {
                return invoiceList;
            }
            throw new InvoiceNotFoundException();
        }
    }

    public List<Invoice> findByRangeDate(LocalDateTime startDate ,LocalDateTime endDate) throws Exception {
        try (CrudRepository<Invoice, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("startDate", startDate);
            params.put("endDate", endDate);
            List<Invoice> invoiceList = repository.executeQuery("Invoice.FindRangeByDate", params, Invoice.class);
            if (!invoiceList.isEmpty()) {
                return invoiceList;
            }
            throw new InvoiceNotFoundException();
        }
    }
}

