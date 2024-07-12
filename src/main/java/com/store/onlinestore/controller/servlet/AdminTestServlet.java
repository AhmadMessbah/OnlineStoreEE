package com.store.onlinestore.controller.servlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Admin;
import com.store.onlinestore.model.service.AdminService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import jakarta.inject.Inject;
import java.io.IOException;

@WebServlet("/admin.do")
public class AdminTestServlet extends HttpServlet {
    @Inject
    private AdminService adminService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Admin admin1 =
                    Admin
                            .builder()
                            .name("leva")
                            .family("ziaee")
                            .username("levaziaei")
                            .password("admin123")
                            .build();


            BeanValidator<Admin> adminValidator = new BeanValidator<>();
            if (adminValidator.validate(admin1).isEmpty()) {
                System.out.println(AdminService.getService().save(admin1));
            } else {
                System.out.println(adminValidator.validate(admin1));
            }


            System.out.println(AdminService.getService().save(admin1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

