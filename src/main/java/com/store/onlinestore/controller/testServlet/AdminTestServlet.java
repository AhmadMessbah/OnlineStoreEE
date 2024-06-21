package com.store.onlinestore.controller.testServlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Admin;
import com.store.onlinestore.model.entity.ProductGroup;
import com.store.onlinestore.model.service.AdminService;
import com.store.onlinestore.model.service.ProductGroupService;
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
                            .name("leva")
                            .family("ziaee")
                            .username("levaziaei")
                            .password("admin123")
                            .build();


            BeanValidator<Admin> adminValidator = new BeanValidator<>();
            if(adminValidator.validate(admin1).isEmpty()) {
                System.out.println(AdminService.getService().save(admin1));
            }else{
                System.out.println(adminValidator.validate(admin1));
            }



            System.out.println(AdminService.getService().save(admin1));
}catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

