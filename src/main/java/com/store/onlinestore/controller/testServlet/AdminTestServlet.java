package com.store.onlinestore.controller.testServlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Admin;
import com.store.onlinestore.model.service.AdminService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin.test")
public class AdminTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Admin admin1 =
                    Admin
                            .builder()
                            .name("ahmad")
                            .family("messbah")
                            .password("123456")
                            .email("a@a.com")
                            .image("/img/0001.jpg")
                            .build();

            Admin admin2 =
                    Admin
                            .builder()
                            .name("ahmad2")
                            .family("messbah2")
                            .password("1234562")
                            .email("a2@a.com")
                            .image("/img/0002.jpg")
                            .build();

            BeanValidator<Admin> adminValidator = new BeanValidator<>();
            if(adminValidator.validate(admin1).isEmpty()) {
                System.out.println(adminValidator.validate(admin1));
            }else{
                System.out.println(adminValidator.validate(admin1));
            }

            if(adminValidator.validate(admin2).isEmpty()) {
                System.out.println(adminValidator.validate(admin2));
            }else{
                System.out.println(adminValidator.validate(admin2));
            }
            System.out.println(AdminService.getService().findAll());

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

