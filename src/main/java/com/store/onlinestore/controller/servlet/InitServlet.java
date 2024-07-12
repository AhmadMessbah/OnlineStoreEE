package com.store.onlinestore.controller.servlet;

import com.store.onlinestore.model.entity.Role;
import com.store.onlinestore.model.entity.User;
import com.store.onlinestore.model.service.UserService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "InitServlet", urlPatterns = "/init.do", loadOnStartup = 1)
public class InitServlet extends HttpServlet {
    @Inject
    private UserService userService;


    @Override
    public void init() throws ServletException {
        try {
            Role role = Role.builder().role("admin").build();
            User user = User
                    .builder()
                    .username("admin")
                    .password("admin")
                    .role(role)
                    .deleted(false)
                    .build();
            userService.save(user);
           log.info("Admin Created !!!");
        } catch (Exception e) {
            log.error("Error in init !!!");
        }
    }
}