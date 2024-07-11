package com.store.onlinestore.controller.servlet;

import com.store.onlinestore.controller.validation.BeanValidator;

import com.store.onlinestore.model.entity.Supplier;

import com.store.onlinestore.model.service.SupplierService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/supplier.test")
public class supplierTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Supplier supplier =
                    Supplier
                            .builder()
                            .name("aaaa")
                            .family("bbbb")
                            .mobilePhone("09131111111")
                            .nationalCode("1234567890")
                            .email("aaa@gmail.com")
                            .email("test@gmail.com")
                            .companyName("seven")
                            .build();

            BeanValidator<Supplier> supplierBeanValidator = new BeanValidator<>();
            if (supplierBeanValidator.validate(supplier).isEmpty()) {
                System.out.println(supplierBeanValidator.validate(supplier));
            } else {
                System.out.println(supplierBeanValidator.validate(supplier));
            }


            System.out.println(SupplierService.getService().findAll());

            System.out.println(SupplierService.getService().findByCompany("seven"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
