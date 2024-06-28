package com.store.onlinestore.controller.testServlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.CashPayment;
import com.store.onlinestore.model.service.CardPaymentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/Cash.test")

public class CashPaymentTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            CashPayment cashPayment1 =
                    CashPayment
                            .builder()
                            .localDateTime(LocalDateTime.now())
                            .build();

            CashPayment cashPayment2 =
                    CashPayment
                            .builder()
                            .localDateTime(LocalDateTime.now())
                            .build();

            BeanValidator<CashPayment> cashValidator = new BeanValidator<>();

            if (cashValidator.validate(cashPayment1).isEmpty()) {
                System.out.println(cashValidator.validate(cashPayment1));
            } else {
                System.out.println(cashValidator.validate(cashPayment1));
            }

            if (cashValidator.validate(cashPayment2).isEmpty()) {
                System.out.println(cashValidator.validate(cashPayment2));
            } else {
                System.out.println(cashValidator.validate(cashPayment2));
            }

            System.out.println(CardPaymentService.getService().findAll());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

