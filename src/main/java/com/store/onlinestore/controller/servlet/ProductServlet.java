package com.store.onlinestore.controller.servlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Product;




import com.store.onlinestore.model.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;


import java.io.IOException;

import java.time.LocalDateTime;
@Slf4j
@WebServlet(urlPatterns ="/product.do")
public class ProductServlet extends HttpServlet {
    @Inject
    private ProductService productService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.getSession().setAttribute("findAllProduct", productService.findAll());
            req.getRequestDispatcher("/product.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());
        }
    }
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
                            .deleted(false)
                            .build();



            BeanValidator<Product> productValidator = new BeanValidator<>();
            if(productValidator.validate(product).isEmpty()) {
                productService.save(product);
                resp.sendRedirect("/product.do");
            }else{
                resp.getWriter().write("<h1 style=\"background-color: red;\">" + productValidator.validate(product) + "</h1>");
           }

        } catch (Exception e) {
            resp.getWriter().write("<h1 style=\"background-color: red;\">" + e.getMessage() + "</h1>");
            System.out.println(e.getMessage());
        }
    }


}
