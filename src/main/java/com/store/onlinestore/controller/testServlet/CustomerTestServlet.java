package com.store.onlinestore.controller.testServlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Customer;
import com.store.onlinestore.model.entity.enums.UserState;
import com.store.onlinestore.model.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/customer.test")
public class CustomerTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Customer customer =
                    Customer
                            .builder()
                            .name("aaaa")
                            .family("bbbb")
                            .username("cccc")
                            .password("123456789")
                            .email("aaa@gmail.com")
                            .phoneNumber("09121234567")
                            .status(UserState.Active)
                            .build();

            BeanValidator<Customer> CustomerValidator = new BeanValidator<>();
            if(CustomerValidator.validate(customer).isEmpty()) {
                System.out.println(CustomerValidator.validate(customer));
            }else{
                System.out.println(CustomerValidator.validate(customer));
            }


            System.out.println(CustomerService.getService().findAll());

            System.out.println(CustomerService.getService().findByUsername("a"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
