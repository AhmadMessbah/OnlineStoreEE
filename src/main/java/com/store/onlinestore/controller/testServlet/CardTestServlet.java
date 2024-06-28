package com.store.onlinestore.controller.testServlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.CardPayment;
import com.store.onlinestore.model.service.CardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/Card.test")
public class CardTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            CardPayment cardPayment1 =
                    CardPayment
                            .builder()
                            .cardNumber(1451547777L)
                            .dateTime(LocalDateTime.now())
                            .build();
            CardPayment cardPayment2 =
                    CardPayment
                            .builder()
                            .cardNumber(5022222L)
                            .dateTime(LocalDateTime.now())
                            .build();

            BeanValidator<CardPayment> cardValidator = new BeanValidator<>();

            if (cardValidator.validate(cardPayment1).isEmpty()) {
                System.out.println(cardValidator.validate(cardPayment1));
            } else {
                System.out.println(cardValidator.validate(cardPayment1));
            }

            if (cardValidator.validate(cardPayment2).isEmpty()) {
                System.out.println(cardValidator.validate(cardPayment2));
            } else {
                System.out.println(cardValidator.validate(cardPayment2));
            }

            System.out.println(CardService.getService().findAll());

            System.out.println(CardService.getService().FindByCardNumber(5022222));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


