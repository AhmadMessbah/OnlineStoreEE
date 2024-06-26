package com.store.onlinestore.controller.testServlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.InventoryTransaction;
import com.store.onlinestore.model.service.InventoryTransactionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/inventory-transaction.test")
public class InventoryTransactionTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            InventoryTransaction inventoryTransaction1 = InventoryTransaction.builder()
                    .registerDateTime(LocalDateTime.of(2024, 6, 22, 7, 7))
                    .unit(null)
                    .group(null)
                    .productList(null)
                    .deliveryPerson(null)
                    .receiverPerson(null)
                    .build();

            InventoryTransaction inventoryTransaction2 = InventoryTransaction.builder()
                    .registerDateTime(LocalDateTime.of(2024, 6, 23, 7, 10))
                    .unit(null)
                    .group(null)
                    .productList(null)
                    .deliveryPerson(null)
                    .receiverPerson(null)
                    .build();

            BeanValidator<InventoryTransaction> inventoryTransactionValidator = new BeanValidator<>();
            if (inventoryTransactionValidator.validate(inventoryTransaction1).isEmpty()) {
                System.out.println(inventoryTransactionValidator.validate(inventoryTransaction1));
            } else {
                System.out.println(inventoryTransactionValidator.validate(inventoryTransaction1));
            }

            if (inventoryTransactionValidator.validate(inventoryTransaction2).isEmpty()) {
                System.out.println(inventoryTransactionValidator.validate(inventoryTransaction2));
            } else {
                System.out.println(inventoryTransactionValidator.validate(inventoryTransaction2));
            }

            System.out.println(InventoryTransactionService.getService().findAll());
            System.out.println(InventoryTransactionService.getService().findByDeliverPerson("ali","alipoor"));
            System.out.println(InventoryTransactionService.getService().findByPhoneNumber("09177712424"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
