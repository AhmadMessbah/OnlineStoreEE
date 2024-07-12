package com.store.onlinestore.controller.servlet;

import com.store.onlinestore.controller.validation.BeanValidator;

import com.store.onlinestore.model.entity.Product;


import com.store.onlinestore.model.entity.ProductUnit;
import com.store.onlinestore.model.service.PersonService;
import com.store.onlinestore.model.service.ProductService;
import com.store.onlinestore.model.service.ProductUnitService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.inject.Inject;
import java.io.EOFException;
import java.io.IOException;

import java.time.LocalDateTime;

@WebServlet("/product.do")
public class ProductServlet extends HttpServlet {
    @Inject
    private ProductService productService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Product product =
                    Product
                            .builder()
                            .name(req.getParameter("name"))
                            .description(req.getParameter("description"))
                            .status(Boolean.parseBoolean(req.getParameter("status")))
                            .brand(req.getParameter("brand"))
                            .unit(null)
                            .productGroup(null)
                            .dateOfModified(LocalDateTime.now())
                            .barcode(req.getParameter("barcode"))
                            .build();



            BeanValidator<Product> productValidator = new BeanValidator<>();
            if(productValidator.validate(product).isEmpty()) {
                productService.save(product);
            }else{
                throw new Exception("Invalid person Data !!!");
           }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
