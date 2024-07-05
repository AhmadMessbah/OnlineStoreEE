package com.store.onlinestore.controller.servlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Manager;
import com.store.onlinestore.model.entity.enums.UserState;
import com.store.onlinestore.model.service.ManagerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/manager.test")
public class ManagerTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Manager manager =
                    Manager
                            .builder()
                            .name("aaaa")
                            .family("bbbb")
                            .username("cccc")
                            .password("123456789")
                            .email("aaa@gmail.com")
                            .phoneNumber("09121234567")
                            .status(UserState.Active)
                            .build();

            BeanValidator<Manager> managerValidator = new BeanValidator<>();
            if(managerValidator.validate(manager).isEmpty()) {
                System.out.println(managerValidator.validate(manager));
            }else{
                System.out.println(managerValidator.validate(manager));
            }


            System.out.println(ManagerService.getService().findAll());

            System.out.println(ManagerService.getService().findByUsername("a"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
