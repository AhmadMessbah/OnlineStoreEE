package com.store.onlinestore.controller.servlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.InvoiceItem;
import com.store.onlinestore.model.service.InvoiceItemService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/invoiceItem.test")
public class InvoiceItemTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            InvoiceItem invoiceItem1=
                    InvoiceItem
                            .builder()
                            .count(100)
                            .price(1000)
                            .build();


            InvoiceItem invoiceItem2=
                    InvoiceItem
                            .builder()
                            .count(200)
                            .price(2000)
                            .build();

            BeanValidator<InvoiceItem> invoiceItemBeanValidator=new BeanValidator<>();
            if (invoiceItemBeanValidator.validate(invoiceItem1).isEmpty()) {
                System.out.println(invoiceItemBeanValidator.validate(invoiceItem1));
            }
            else {
                System.out.println(invoiceItemBeanValidator.validate(invoiceItem1));
            }

            if (invoiceItemBeanValidator.validate(invoiceItem2).isEmpty()) {
                System.out.println(invoiceItemBeanValidator.validate(invoiceItem2));
            }
            else {
                System.out.println(invoiceItemBeanValidator.validate(invoiceItem2));
            }


            System.out.println(InvoiceItemService.getService().findAll());


        }
        catch(Exception e){
            System.out.println(e.getMessage());

        }
    }

}

