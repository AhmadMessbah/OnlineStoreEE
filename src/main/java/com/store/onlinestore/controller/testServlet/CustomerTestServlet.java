package com.store.onlinestore.controller.testServlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Customer;
import com.store.onlinestore.model.entity.enums.UserState;
import com.store.onlinestore.model.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
                            .status(UserState.Active)
                            .build();

            BeanValidator<Customer> personValidator = new BeanValidator<>();
            if(personValidator.validate(customer).isEmpty()) {
                System.out.println(personValidator.validate(customer));
            }else{
                System.out.println(personValidator.validate(customer));
            }


            System.out.println(CustomerService.getService().findAll());

            System.out.println(CustomerService.getService().findByUsername("a"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
