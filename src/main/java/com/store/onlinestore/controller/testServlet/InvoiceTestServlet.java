package com.store.onlinestore.controller.testServlet;


import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.*;

import com.store.onlinestore.model.service.InvoiceService;
import com.store.onlinestore.model.service.ProductGroupService;
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
            Person person1 =
                    Person
                            .builder()
                            .name("Arash")
                            .family("Oloomi")
                            .phoneNumber("123456")
                            .email("a@a.com")
                            .image("/img/0001.jpg")
                            .build();

            Product product1 =
                    Product
                            .builder()
                            .name("mobile")
                            .brand("samsung")
                            .build();

            Product product2 =
                    Product
                            .builder()
                            .name("laptop")
                            .brand("Asus")
                            .build();

            Product product3 =
                    Product
                            .builder()
                            .name("monitor")
                            .brand("lg")
                            .build();

            InvoiceItem invoiceItem1 =
                    InvoiceItem
                            .builder()
                            .product(product1)
                            .count(2)
                            .price(1000)
                            .build();

            InvoiceItem invoiceItem2 =
                    InvoiceItem
                            .builder()
                            .product(product2)
                            .count(3)
                            .price(2500)
                            .build();

            InvoiceItem invoiceItem3 =
                    InvoiceItem
                            .builder()
                            .count(5)
                            .price(500)
                            .product(product3)
                            .build();

            List<InvoiceItem> invoiceItemList = new ArrayList<>();
            invoiceItemList.add(invoiceItem1);
            invoiceItemList.add(invoiceItem2);
            invoiceItemList.add(invoiceItem3);

            Invoice invoice =
                    Invoice
                            .builder()
                            .serial("ab-123")
                            .customer(person1)
                            .invoiceItemList(invoiceItemList)
//                            .discount(100)
                            .localDateTime(LocalDateTime.now())
                            .build();

            BeanValidator<Invoice> invoiceValidator = new BeanValidator<>();
//            if(invoiceValidator.validate(invoice).isEmpty()) {
//                System.out.println(InvoiceService.getService().save(invoice));
//            }else{
//                System.out.println(invoiceValidator.validate(invoice));
//            }

            if(invoiceValidator.validate(invoice).isEmpty()) {
                System.out.println(InvoiceService.getService().edit(invoice));
            }else{
                System.out.println(invoiceValidator.validate(invoice));
            }


            System.out.println(InvoiceService.getService().findAll());
            System.out.println(InvoiceService.getService().findById(1L));
            System.out.println(InvoiceService.getService().findBySerial("ab-123"));
            System.out.println(InvoiceService.getService().findByCustomer(person1));
            System.out.println(InvoiceService.getService().findByDate(LocalDateTime.now()));
            //TODO
//            System.out.println(InvoiceService.getService().findByRangeDate());


        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}