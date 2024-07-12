package com.store.onlinestore.controller.servlet;

import com.store.onlinestore.controller.validation.BeanValidator;

import com.store.onlinestore.model.entity.Supplier;

import com.store.onlinestore.model.service.InventoryTransactionService;
import com.store.onlinestore.model.service.SupplierService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/supplier.do")
public class supplierTestServlet extends HttpServlet {
    @Inject
    private SupplierService supplierService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Supplier supplier =
                    Supplier
                            .builder()
                            .name(req.getParameter("name_supplier"))
                            .family(req.getParameter("family_supplier"))
                            .mobilePhone(req.getParameter("mobilePhone_supplier"))
                            .nationalCode(req.getParameter("nationalCode_supplier"))
                            .email(req.getParameter("email_supplier"))
                            .companyName(req.getParameter("companyName_supplier"))
                            .build();

            BeanValidator<Supplier> supplierBeanValidator = new BeanValidator<>();
            if (supplierBeanValidator.validate(supplier).isEmpty()) {
                supplierService.save(supplier);
            } else {
                throw new Exception("Invalid InventoryTransaction Data !!!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
