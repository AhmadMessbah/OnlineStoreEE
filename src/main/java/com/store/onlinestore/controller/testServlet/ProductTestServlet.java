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
import java.time.LocalTime;

@WebServlet("/product.test")
public class ProductTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Product product1 =
                    Product
                            .builder()
                            .name("sabon")
                            .description("sabz")
                            .status(true)
                            .brand("golnar")
                            .unitId(null)
                            .productGroupId(null)
                            .price(10000)
//                            .image("/img/0001.jpg")
                            .dateOfModified(Time.valueOf(LocalTime.now()))
                            .barcode("021655632")
//                            .inStock(0)
                            .build();

            Product product2 =
                    Product
                            .builder()
                            .name("mooz")
                            .description("zard")
                            .status(true)
                            .brand("amrica")
                            .unitId(null)
                            .productGroupId(null)
                            .price(20000)
                       //     .image("/img/0002.jpg")
                            .dateOfModified(Time.valueOf(LocalTime.now()))
                            .barcode("54684")
                      //      .inStock(1)
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


            System.out.println(ProductService.getService().findByNameAndBrand("m","z"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }



}
