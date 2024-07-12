package com.store.onlinestore.controller.servlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Person;
import com.store.onlinestore.model.service.PersonService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.inject.Inject;
import java.io.IOException;

@WebServlet("/person.do")
public class PersonServlet extends HttpServlet {
    @Inject
    private PersonService personService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Person person =
                    Person
                            .builder()
                            .name(req.getParameter("name"))
                            .family(req.getParameter("family"))
                            .phoneNumber(req.getParameter("phone"))
                            .email(req.getParameter("email"))
                            .image(req.getParameter("image"))
                            .build();


            BeanValidator<Person> personValidator = new BeanValidator<>();

            if(personValidator.validate(person).isEmpty()) {
                personService.save(person);
            }else{
                throw new Exception("Invalid Person Data !!!");  //error
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
