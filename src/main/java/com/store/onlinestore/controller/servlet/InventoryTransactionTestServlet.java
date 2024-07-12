package com.store.onlinestore.controller.servlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Inventory;
import com.store.onlinestore.model.entity.InventoryTransaction;
import com.store.onlinestore.model.service.InventoryService;
import com.store.onlinestore.model.service.InventoryTransactionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.inject.Inject;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/inventory-transaction.do")
public class InventoryTransactionTestServlet extends HttpServlet {
    @Inject
    private InventoryTransactionService inventoryTransactionService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            InventoryTransaction inventoryTransaction =
                    InventoryTransaction
                            .builder()
                            .productId(null)
                            .deliveryPerson(null)
                            .receiverPerson(null)
                            .build();

            BeanValidator<InventoryTransaction> inventoryTransactionValidator = new BeanValidator<>();
            if (inventoryTransactionValidator.validate(inventoryTransaction).isEmpty()) {
                inventoryTransactionService.save(inventoryTransaction);
            } else {
                throw new Exception("Invalid InventoryTransaction Data !!!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
