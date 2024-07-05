package com.store.onlinestore.controller.testServlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Inventory;

import com.store.onlinestore.model.service.InventoryService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/inventory.test")
public class InventoryTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Inventory inventory =
                    Inventory
                            .builder()
                            .description("Test Inventory Servlet")
//                            .productStock(10)
                            .product(null)
                            .supplierList(null)
                            .build();

            BeanValidator<Inventory> inventoryBeanValidator = new BeanValidator<>();
            if (inventoryBeanValidator.validate(inventory).isEmpty()) {
                System.out.println(inventoryBeanValidator.validate(inventory));
            } else {
                System.out.println(inventoryBeanValidator.validate(inventory));
            }

            System.out.println(InventoryService.getService().findAll());
        } catch (
                Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
