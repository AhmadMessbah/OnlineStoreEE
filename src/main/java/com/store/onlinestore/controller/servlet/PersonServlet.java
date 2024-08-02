package com.store.onlinestore.controller.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
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
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.validator.routines.UrlValidator;

import java.io.IOException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@WebServlet("/person.do")
public class PersonServlet extends HttpServlet {
    Map<String, String> csrfTokens = new HashMap<>();

    @Inject
    private PersonService personService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(getClass().getResource("/test"));

//        byte[] bytes = new byte[32];
//        SecureRandom secureRandom = new SecureRandom();
//
//        secureRandom.nextBytes(bytes);
//
//        String token = Base64.getUrlEncoder().withoutPadding().encode(bytes).toString();
//
//        csrfTokens.put(req.getSession().getAttribute("username").toString() , token);
//        resp.setHeader("X_CSRF_TOKEN", bytes.toString());

//        req.getSession().setAttribute("csrf_token", token);

        try {
            if (req.getParameter("edit") != null) {
                System.out.println("Edit : " + Long.parseLong(req.getParameter("edit")));
                Person person = personService.findById(Long.parseLong(req.getParameter("edit")));
                if(!person.isEditing()) {
                    person.setEditing(true);
                    req.getSession().setAttribute("person", person);

                    req.getRequestDispatcher("edit-person.jsp").forward(req, resp);
                }else{
                    System.out.println("Record is editing by another person");
                }
            }

            List<Person> personList = personService.findAll();
//            if (personList != null && !personList.isEmpty()){
            req.getSession().setAttribute("personList", personList);
//            }else{
//                req.getSession().setAttribute("personList", null);
//            }

        } catch (Exception e) {
            System.out.println("Khata");
            ;
        }

        req.getRequestDispatcher("person.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
//            String csrfToken = req.getSession().getAttribute("csrf_token").toString();
//            if (csrfTokens.get(req.getSession().getAttribute("username").toString()).equals(csrfToken)) {}
//            if(req.getHeader("X_CSRF_TOKEN").equals(csrfTokens.get(req.getSession().getAttribute("username").toString()))) {}
//          todo: check in db if user has valid token

//            Part filePart = req.getPart("file");

//          todo : resource path
//            String fileName = "c:\\root\\" + filePart.getSubmittedFileName();
//            System.out.println("File : " + fileName);
//            for (Part part : req.getParts()) {
//                part.write(fileName);
//            }

//            Attachment attachment = Attachment
//                    .builder()
//                    .localDateTime(LocalDateTime.now())
//                    .filename(fileName)
//                    .fileType(FileType.Jpg)
//                    .fileSize(filePart.getSize())
//                    .build();

//          XSS - SQL Injection
//            String name =StringEscapeUtils.escapeHtml4(req.getParameter("name"));
//            UrlValidator urlValidator = new UrlValidator();
//            urlValidator.isValid(req.getRequestURL().toString());
            Person person =
                    Person
                            .builder()
                            .name(StringEscapeUtils.escapeHtml4(req.getParameter("name")))
                            .family(req.getParameter("family"))
//                            .phoneNumber(req.getParameter("phone"))
//                            .email(req.getParameter("email"))
//                            .image(attachment)
                            .build();

            BeanValidator<Person> personValidator = new BeanValidator<>();

            if (personValidator.validate(person).isEmpty()) {
                personService.save(person);
                resp.sendRedirect("/person.do");
                log.info("Person saved successfully : " + person.toString());
            } else {
                throw new Exception("Invalid Person Data !!!");  //error
            }
        } catch (Exception e) {
            log.error(ExceptionWrapper.getMessage(e).toString());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
           System.out.println("PERSON PUT : ");
//           Gson gson = new Gson();
//        gson.fromJson(req.getReader(), Person.class);
           ObjectMapper objectMapper = new ObjectMapper();
           Person person = objectMapper.readValue(req.getReader(), Person.class);
           person.setEditing(false);
           System.out.println(person);
           personService.edit(person);
       }catch (Exception e){

       }
    }
}
