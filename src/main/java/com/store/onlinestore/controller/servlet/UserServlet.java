package com.store.onlinestore.controller.servlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Customer;
import com.store.onlinestore.model.entity.Person;
import com.store.onlinestore.model.entity.User;
import com.store.onlinestore.model.entity.enums.UserState;
import com.store.onlinestore.model.service.CustomerService;
import com.store.onlinestore.model.service.UserService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user.do")

public class UserServlet extends HttpServlet {

    @Inject
    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{
            User user =
                    User
                            .builder()
                            .username("aaa")
                            .password("123")
                            .build();


            BeanValidator<User> personValidator = new BeanValidator<>();

            if(personValidator.validate(user).isEmpty()) {
                userService.save(user);
            }else{
                throw new Exception("Invalid User Data !!!");  //error
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

