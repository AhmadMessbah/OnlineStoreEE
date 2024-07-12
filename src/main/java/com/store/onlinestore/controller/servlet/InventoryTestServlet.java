package com.store.onlinestore.controller.servlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Inventory;
import com.store.onlinestore.model.service.InventoryService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/inventory.do")
public class InventoryTestServlet extends HttpServlet {
    @Inject
    private InventoryService inventoryService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Inventory inventory =
                    Inventory
                            .builder()
                            .name(req.getParameter("name_inventory"))
                            .description(req.getParameter("description_inventory"))
                            .count(Integer.parseInt(req.getParameter("count_inventory")))
                            .loction(req.getParameter("loction_inventory"))
                            .product(null)
                            .supplierList(null)
                            .build();

            BeanValidator<Inventory> inventoryBeanValidator = new BeanValidator<>();
            if (inventoryBeanValidator.validate(inventory).isEmpty()) {
                inventoryService.save(inventory);
            } else {
                throw new Exception("Invalid Inventory Data !!!");  //error
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
