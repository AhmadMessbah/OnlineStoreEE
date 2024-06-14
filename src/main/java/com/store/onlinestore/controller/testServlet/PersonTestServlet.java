package com.store.onlinestore.controller.testServlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Person;
import com.store.onlinestore.model.service.PersonService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/person.test")
public class PersonTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Person person1 =
                    Person
                            .builder()
                            .name("ahmad")
                            .family("messbah")
                            .phoneNumber("123456")
                            .email("a@a.com")
                            .image("/img/0001.jpg")
                            .build();

            Person person2 =
                    Person
                            .builder()
                            .name("ahmad2")
                            .family("messbah2")
                            .phoneNumber("1234562")
                            .email("a2@a.com")
                            .image("/img/0002.jpg")
                            .build();

            BeanValidator<Person> personValidator = new BeanValidator<>();
            if(personValidator.validate(person1).isEmpty()) {
                System.out.println(personValidator.validate(person1));
            }else{
                System.out.println(personValidator.validate(person1));
            }


            if(personValidator.validate(person2).isEmpty()) {
                System.out.println(personValidator.validate(person2));
            }else{
                System.out.println(personValidator.validate(person2));
            }

            System.out.println(PersonService.getService().findAll());

            System.out.println(PersonService.getService().findByNameAndFamily("a","m"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
