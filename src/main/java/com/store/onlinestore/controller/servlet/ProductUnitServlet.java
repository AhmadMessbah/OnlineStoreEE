package com.store.onlinestore.controller.servlet;

import com.store.onlinestore.controller.validation.BeanValidator;

import com.store.onlinestore.model.entity.ProductUnit;
import com.store.onlinestore.model.service.ProductUnitService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/product-unit.do")
public class ProductUnitServlet extends HttpServlet {
    @Inject
    private ProductUnitService productUnitService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.getSession().setAttribute("findAllProductUnits", productUnitService.findAll());
            req.getRequestDispatcher("/product-unit.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            ProductUnit productUnit =
                    ProductUnit
                            .builder()
                            .name(req.getParameter("name"))
                            .symbol(req.getParameter("symbol"))
                            .description(req.getParameter("description"))
                            .deleted(false)
                            .build();

            BeanValidator<ProductUnit> productGroupValidator = new BeanValidator<>();
            if (productGroupValidator.validate(productUnit).isEmpty()) {
                productUnitService.save(productUnit);
                    resp.sendRedirect("/product-unit.do");

            } else {
                resp.getWriter().write("<h1 style=\"background-color: red;\">" + productGroupValidator.validate(productUnit) + "</h1>");


            }

        } catch (Exception e) {
            resp.getWriter().write("<h1 style=\"background-color: red;\">" + e.getMessage() + "</h1>");

            System.out.println("Error : " + e.getMessage());
        }
    }
}
