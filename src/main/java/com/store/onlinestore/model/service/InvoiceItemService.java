package com.store.onlinestore.model.service;


import com.store.onlinestore.model.entity.InvoiceItem;
import com.store.onlinestore.model.entity.Person;
import com.store.onlinestore.model.repository.CrudRepository;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InvoiceItemService {


    @Getter
    private static InvoiceItemService service = new InvoiceItemService();

    private InvoiceItemService() {
    }

    public InvoiceItem save(InvoiceItem invoiceItem) throws Exception {
        try (CrudRepository<InvoiceItem, Long> repository = new CrudRepository<>()) {
            return repository.save(invoiceItem);
        }
    }

    public InvoiceItem edit(InvoiceItem invoiceItem) throws Exception {
        try (CrudRepository<InvoiceItem, Long> repository = new CrudRepository<>()) {
            return repository.edit(invoiceItem);
        }
    }

    //    todo : convert to logical remove
    public InvoiceItem remove(Long id) throws Exception {
        try (CrudRepository<InvoiceItem, Long> repository = new CrudRepository<>()) {
            return repository.remove(id, InvoiceItem.class);
        }
    }

    public List<InvoiceItem> findAll() throws Exception {
        try (CrudRepository<InvoiceItem, Long> repository = new CrudRepository<>()) {
            return  repository.findAll(InvoiceItem.class);
        }
    }

    public InvoiceItem findById(Long id) throws Exception{
        try (CrudRepository<InvoiceItem, Long> repository = new CrudRepository<>()) {
            return repository.findById(id, InvoiceItem.class);
        }
    }
//    public List<InvoiceItem>  findByName(String name) throws Exception {
//        try (CrudRepository<InvoiceItem, Long> repository = new CrudRepository<>()){
//            Map<String,Object> params = new HashMap<>();
//            params.put("name", name+"%");
//            return repository.executeQuery("InvoiceItem.FindByName",params, InvoiceItem.class);
//        }
//    }


}
