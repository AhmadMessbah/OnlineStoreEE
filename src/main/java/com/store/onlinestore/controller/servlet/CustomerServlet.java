package com.store.onlinestore.controller.servlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Customer;
import com.store.onlinestore.model.entity.enums.UserState;
import com.store.onlinestore.model.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.inject.Inject;
import java.io.IOException;

@WebServlet("/customer.do")
public class CustomerServlet extends HttpServlet {

    @Inject
    private CustomerService customerService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Customer customer =
                    Customer
                            .builder()
                            .name("name")
                            .family("family")
                            .username("user1")
                            .password("123456789")
                            .email("email@gmail.com")
                            .phoneNumber("09121234567")
                            .nationalCode("1234567890")
//                            .address(address)
                            .status(UserState.Active)
                            .build();

            BeanValidator<Customer> CustomerValidator = new BeanValidator<>();
            if(CustomerValidator.validate(customer).isEmpty()) {
                customerService.save(customer);
            }else{
                throw new Exception("Invalid Customer Data !!!");  //error
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
