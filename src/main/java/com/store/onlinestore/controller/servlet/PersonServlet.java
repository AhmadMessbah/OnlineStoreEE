package com.store.onlinestore.controller.servlet;

import com.store.onlinestore.controller.exception.ExceptionWrapper;
import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Attachment;
import com.store.onlinestore.model.entity.Person;
import com.store.onlinestore.model.entity.enums.FileType;
import com.store.onlinestore.model.service.PersonService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.inject.Inject;
import jakarta.servlet.http.Part;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.LocalDateTime;

@Slf4j
@WebServlet("/person.do")
public class PersonServlet extends HttpServlet {
    @Inject
    private PersonService personService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Part filePart = req.getPart("file");
            String fileName = "c:\\root\\" + filePart.getSubmittedFileName();
            System.out.println("File : " + fileName);
            for (Part part : req.getParts()) {
                part.write(fileName);
            }

            Attachment attachment = Attachment
                    .builder()
                    .localDateTime(LocalDateTime.now())
                    .filename(fileName)
                    .fileType(FileType.Jpg)
                    .fileSize(filePart.getSize())
                    .build();


            Person person =
                    Person
                            .builder()
                            .name(req.getParameter("name"))
                            .family(req.getParameter("family"))
                            .phoneNumber(req.getParameter("phone"))
                            .email(req.getParameter("email"))
                            .image(attachment)
                            .build();

            BeanValidator<Person> personValidator = new BeanValidator<>();

            if (personValidator.validate(person).isEmpty()) {
                personService.save(person);
                log.info("Person saved successfully : " + person.toString());
            } else {
                throw new Exception("Invalid Person Data !!!");  //error
            }
        } catch (Exception e) {
            log.error(ExceptionWrapper.getMessage(e).toString());
        }
    }
}
