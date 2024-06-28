package com.store.onlinestore.controller.testServlet;

import com.store.onlinestore.controller.validation.BeanValidator;

import com.store.onlinestore.model.entity.Product;


import com.store.onlinestore.model.service.ProductGroupService;
import com.store.onlinestore.model.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;

@WebServlet("/product.test")
public class ProductTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Product product1 =
                    Product
                            .builder()
                            .name("car")
                            .description("black")
                            .status(true)
                            .brand("benz")
                            .unit(null)
                            .productGroup(null)
                            .dateOfModified(LocalDateTime.now())
                            .barcode("021655632")
                            .build();

            Product product2 =
                    Product
                            .builder()
                            .name("laptop")
                            .description("xs55")
                            .status(true)
                            .brand("asus")
                            .unit(null)
                            .productGroup(null)
                            .dateOfModified(LocalDateTime.now())
                            .barcode("54684")
                            .build();

            BeanValidator<Product> productValidator = new BeanValidator<>();
//            if(productValidator.validate(product1).isEmpty()) {
//                System.out.println(productValidator.validate(product1));
//                System.out.println(ProductService.getService().save(product1));
//                System.out.println(ProductService.getService().save(product2));
//            }else{
//                System.out.println(productValidator.validate(product1));
//            }
//
//
//            if(productValidator.validate(product2).isEmpty()) {
//                System.out.println(productValidator.validate(product2));
//                System.out.println(ProductService.getService().edit(product2));
//            }else{
//                System.out.println(productValidator.validate(product2));
//            }


            System.out.println(ProductService.getService().findAll());
            System.out.println(ProductService.getService().FindByBarcode("54684"));


            System.out.println(ProductService.getService().findByNameAndBrand("c", "b"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
