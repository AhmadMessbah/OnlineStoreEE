package com.store.onlinestore.controller.servlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import jakarta.servlet.annotation.HttpMethodConstraint;
import com.store.onlinestore.model.entity.CardPayment;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import java.time.LocalDateTime;
import java.io.IOException;

@ServletSecurity(
        value = @HttpConstraint(
                rolesAllowed = {"cashPayment"}
        ),

        httpMethodConstraints =
        @HttpMethodConstraint(
                value = "GET",
                rolesAllowed = {"cashPayment"}
        )
)

@WebServlet("/Card.do")
public class CardPaymentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            CardPayment cardPayment1 =
                    CardPayment
                            .builder()
                            .cardNumber(1451547777L)
                            .paymentDateTime(LocalDateTime.now())
                            .bankName("Meli")
                            .build();
            CardPayment cardPayment2 =
                    CardPayment
                            .builder()
                            .cardNumber(5022222L)
                            .paymentDateTime(LocalDateTime.now())
                            .bankName("Sepah")
                            .build();

            // todo : Error Card payment service
            BeanValidator<CardPayment> cardPaymentBeanValidator = new BeanValidator<>();
            if (cardPaymentBeanValidator.validate(cardPayment1).isEmpty()) {
//                System.out.println(CardPaymentService.getService.save(cardPayment1));
            } else {
                System.out.println(cardPaymentBeanValidator.validate(cardPayment1));
            }

//            System.out.println(CardPaymentService.getService().save(cardPayment2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


