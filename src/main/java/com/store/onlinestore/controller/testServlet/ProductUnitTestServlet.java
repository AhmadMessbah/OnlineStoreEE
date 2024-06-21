package com.store.onlinestore.controller.testServlet;

import com.store.onlinestore.model.entity.ProductUnit;
import com.store.onlinestore.model.service.ProductUnitService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/unit.test")
public class ProductUnitTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ProductUnit productUnit1 = ProductUnit.builder()
                    .name("ddd")
                    .symbol("kg")
                    .description("hhhh")
                    .build();

            ProductUnit productUnit2 = ProductUnit.builder()
                    .name("qqq")
                    .symbol("ml")
                    .description("ssss")
                    .build();

//            System.out.println(ProductUnitService.getService().save(productUnit1));
//            System.out.println(ProductUnitService.getService().save(productUnit2));

//            System.out.println(ProductUnitService.getService().edit(productUnit1));
//            System.out.println(ProductUnitService.getService().edit(productUnit2));

//            System.out.println(ProductUnitService.getService().remove(productUnit1.getId()));

//            System.out.println(ProductUnitService.getService().findAll());

//            System.out.println(ProductUnitService.getService().findByName("q"));

//            System.out.println(ProductUnitService.getService().findById(2L));
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
