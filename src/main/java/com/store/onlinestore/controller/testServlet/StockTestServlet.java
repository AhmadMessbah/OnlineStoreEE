package com.store.onlinestore.controller.testServlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Inventory;
import com.store.onlinestore.model.entity.Stock;
import com.store.onlinestore.model.entity.Supplier;
import com.store.onlinestore.model.service.StockService;
import com.store.onlinestore.model.service.SupplierService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/stock.test")
public class StockTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Stock stock =
                    Stock
                            .builder()
                            .stockDescription("description ...")
                            .stockItems("bbbb")
                            .stockNumber(10)
                            .stockType("test")
//                            .inventoryList()
                            .build();

            BeanValidator<Stock> stockBeanValidator = new BeanValidator<>();
            if (stockBeanValidator.validate(stock).isEmpty()) {
                System.out.println(stockBeanValidator.validate(stock));
            } else {
                System.out.println(stockBeanValidator.validate(stock));
            }


            System.out.println(StockService.getService().findAll());

            System.out.println(StockService.getService().findAll());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
