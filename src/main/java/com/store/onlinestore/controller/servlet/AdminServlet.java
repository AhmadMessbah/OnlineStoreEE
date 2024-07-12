package com.store.onlinestore.controller.servlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Admin;
import com.store.onlinestore.model.entity.Person;
import com.store.onlinestore.model.service.AdminService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import javax.inject.Inject;
import java.io.IOException;

@WebServlet("/admin.do")
public class AdminServlet extends HttpServlet {
    @Inject
    private AdminService adminService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Admin admin =
                    Admin
                            .builder()
                            .name("leva")
                            .family("ziaee")
                            .username("levaziaei")
                            .password("admin123")
                            .build();


            BeanValidator<Admin> adminValidator = new BeanValidator<>();

            if(adminValidator.validate(admin).isEmpty()) {
                adminValidator.save(admin);
            }else{
                throw new Exception("Invalid Person Data !!!");  //error
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

