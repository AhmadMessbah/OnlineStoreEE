package com.store.onlinestore.controller.servlet;


import com.store.onlinestore.controller.exception.ExceptionWrapper;
import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.*;


import com.store.onlinestore.model.service.InvoiceService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@WebServlet("/invoice.do")
public class InvoiceServlet extends HttpServlet {
    @Inject
    private InvoiceService invoiceService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            Long customerId = Long.valueOf(req.getParameter("customer"));
            Customer customer =
                    Customer
                            .builder()
                            .id(customerId)

                            .build();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            Product product1 =
                    Product
                            .builder()
                            .id(1L)
                            .build();

            Product product2 =
                    Product
                            .builder()
                            .id(2L)
                            .build();


            Invoice invoice =
                    Invoice
                            .builder()
                            .serial(req.getParameter("serial"))
                            .customer(customer)
                            .localDateTime(LocalDateTime.parse(req.getParameter("localDateTime"), formatter))
                            .invoiceComment(req.getParameter("invoiceComment"))
                            .discount(Integer.parseInt(req.getParameter("discount")))
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

            if (invoiceValidator.validate(invoice).isEmpty()) {
                invoiceService.save(invoice);
                log.info("Invoice saved successfully : " + invoice.toString());
            } else {
                throw new Exception("Invalid Invoice Data !!!");  //error
            }
        //            TODO
        //HTTP Status 404 – Not Found
        //Type Status Report
//
        //Description The origin server did not find a current representation for the target resource or is not willing to disclose that one exists.
//
        //Apache Tomcat (TomEE)/10.0.27 (9.1.3)

    } catch(Exception e){
        e.printStackTrace();
        log.error(ExceptionWrapper.getMessage(e).toString());
    }
}
}

