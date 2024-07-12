package com.store.onlinestore.controller.servlet;

import com.store.onlinestore.model.entity.Role;
import com.store.onlinestore.model.entity.User;
import com.store.onlinestore.model.service.UserService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(name = "/init.do", loadOnStartup = 1)
public class InitServlet extends HttpServlet {
    @Inject
    private UserService userService;


    @Override
    public void init() throws ServletException {
        try{
            User user = User.builder().username("admin").password("admin").deleted(false).build();
            Role role = Role.builder().role("admin").build();
            userService.save(user);
            System.out.println("Admin Created !!!");
        }catch (Exception e){
            System.out.println("Error in init !!!");
        }
    }
}