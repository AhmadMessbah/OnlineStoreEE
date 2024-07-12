package com.store.onlinestore.controller.servlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Manager;
import com.store.onlinestore.model.entity.enums.UserState;
import com.store.onlinestore.model.service.ManagerService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/manager.do")
public class ManagerServlet extends HttpServlet {
    @Inject
    private ManagerService managerService;
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
                            .nationalCode("1234567890")
                            .status(UserState.Active)
                            .build();

            BeanValidator<Manager> ManagerValidator = new BeanValidator<>();
            if(ManagerValidator.validate(manager).isEmpty()) {
                managerService.save(manager);
            }else {
                throw new Exception("Invalid Manager Data !!!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
