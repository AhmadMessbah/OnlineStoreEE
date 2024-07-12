package com.store.onlinestore.controller.servlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.ProductGroup;

import com.store.onlinestore.model.service.ProductGroupService;


import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebServlet(urlPatterns = "/product-group.do")
public class ProductGroupServlet extends HttpServlet {

    @Inject
    private ProductGroupService productGroupService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println(productGroupService.findByName("hgh"));
            req.getSession().setAttribute("findAllProductGroups", productGroupService.findAll());
            req.getRequestDispatcher("/product-group.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            ProductGroup parentProductGroup = null;
            if (req.getParameter("parent") != null) {
                parentProductGroup = productGroupService.findByName(req.getParameter("parent"));
            }

            ProductGroup productGroup =
                    ProductGroup
                            .builder()
                            .name(req.getParameter("name"))
                            .description(req.getParameter("description"))
                            .status(true)
//                            .parentGroup(parentProductGroup)
                            .deleted(false)
                            .build();

            BeanValidator<ProductGroup> productGroupValidator = new BeanValidator<>();
            if (productGroupValidator.validate(productGroup).isEmpty()) {
                if (productGroupService.findByName(productGroup.getName()) == null) {
                    log.info(productGroup.toString());
                    productGroupService.save(productGroup);
                    if (parentProductGroup != null) {
                        parentProductGroup.addChildGroup(productGroup);
                        productGroupService.edit(parentProductGroup);
                    }
                    resp.sendRedirect("/product-group.do");
                } else {
                    resp.getWriter().write("<h1 style=\"background-color: yellow;\">" + "Duplicate product group name !!!" + "</h1>");

                    System.out.println("Duplicate product group name !!!");
                }

            } else {
                resp.getWriter().write("<h1 style=\"background-color: yellow;\">" + productGroupValidator.validate(productGroup) + "</h1>");

                System.out.println(productGroupValidator.validate(productGroup));
            }

        } catch (Exception e) {
            resp.getWriter().write("<h1 style=\"background-color: yellow;\">" + e.getMessage() + "</h1>");
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());
        }
    }

}
