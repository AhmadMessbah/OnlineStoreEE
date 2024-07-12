package com.store.onlinestore.controller.servlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Manager;
import com.store.onlinestore.model.entity.Role;
import com.store.onlinestore.model.entity.enums.UserState;
import com.store.onlinestore.model.service.ManagerService;
import com.store.onlinestore.model.service.RoleService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/role.do")
public class RoleServlet extends HttpServlet {
    @Inject
    private RoleService roleService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Role role =
                    Role
                            .builder()
                            .role("admin")
                            .build();

            BeanValidator<Role> RoleValidator = new BeanValidator<>();
            if(RoleValidator.validate(role).isEmpty()) {
                roleService.save(role);
            }else {
                throw new Exception("Invalid Role Data !!!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}