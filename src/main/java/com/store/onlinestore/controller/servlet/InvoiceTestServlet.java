package com.store.onlinestore.controller.servlet;


import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/invoice.test")
public class InvoiceTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Customer customer =
                    Customer
                            .builder()
                            .id(1L)

                            .build();

            Product product1 =
                    Product
                            .builder()
                            .id(1L)
                            .build();

            Product product2 =
                    Product
                            .builder()
                            .id(1L)
                            .build();

            Invoice invoice =
                    Invoice
                            .builder()
//                            .id(2L)
                            .serial("A-00001")
                            .customer(customer)
                            .localDateTime(LocalDateTime.now())
                            .discount(150)
                            .build();

            InvoiceItem invoiceItem1 =
                    InvoiceItem
                            .builder()
                            .product(product1)
                            .count(2)
                            .price(1000)
                            .invoice(invoice)
                            .build();

            InvoiceItem invoiceItem2 =
                    InvoiceItem
                            .builder()
                            .product(product2)
                            .count(3)
                            .price(2500)
                            .invoice(invoice)
                            .build();

            List<InvoiceItem> invoiceItemList = new ArrayList<>();
            invoiceItemList.add(invoiceItem1);
            invoiceItemList.add(invoiceItem2);
            invoice.setInvoiceItemList(invoiceItemList);

            int amount = invoice.getAmount();
            int pureAmount = invoice.getPureAmount();

            invoice.setAmount(amount);
            invoice.setPureAmount(pureAmount);

            BeanValidator<Invoice> invoiceValidator = new BeanValidator<>();
//            if (invoiceValidator.validate(invoice).isEmpty()) {
//                System.out.println(InvoiceService.getService().save(invoice));
//            } else {
//                System.out.println(invoiceValidator.validate(invoice));
//            }
////
//
//
//            if(invoiceValidator.validate(invoice).isEmpty()) {
//                System.out.println(InvoiceService.getService().edit(invoice));
//            }else {
//                System.out.println(invoiceValidator.validate(invoice));
//            }
//
//
//            if(invoiceValidator.validate(invoice).isEmpty()) {
//                System.out.println(InvoiceService.getService().remove(1L));
//            }else{
//                System.out.println(invoiceValidator.validate(invoice));
//            }
////
            //TODO failed to lazily initialize a collection of role: com.store.onlinestore.model.entity.Invoice.invoiceItemList: could not initialize proxy - no Session
//            System.out.println(InvoiceService.getService().findAll());
//            System.out.println(InvoiceService.getService().findById(1L));
//            System.out.println(InvoiceService.getService().findBySerial("ab-123"));
//            System.out.println(InvoiceService.getService().findByCustomer(2L));
//            System.out.println(InvoiceService.getService().findByDate(LocalDateTime.now()));
            //TODO
//            System.out.println(InvoiceService.getService().findByRangeDate());


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}