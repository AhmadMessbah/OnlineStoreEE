package com.store.onlinestore.controller.servlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import jakarta.servlet.annotation.HttpMethodConstraint;
import com.store.onlinestore.model.entity.CashPayment;
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

@WebServlet("/Cash.test")
public class CashPaymentTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            CashPayment cashPayment1 =
                    CashPayment
                            .builder()
                            .paymentDateTime(LocalDateTime.now())
                            .build();

            CashPayment cashPayment2 =
                    CashPayment
                            .builder()
                            .paymentDateTime(LocalDateTime.now())
                            .build();

            // todo : Error cash payment service
            BeanValidator<CashPayment> cashPaymentBeanValidator = new BeanValidator<>();
            if (cashPaymentBeanValidator.validate(cashPayment1).isEmpty()) {
//                System.out.println(CashPaymentService.getService.save(cashPayment1));
            } else {
                System.out.println(cashPaymentBeanValidator.validate(cashPayment1));
            }

//            System.out.println(CashPaymentService.getService().save(cashPayment2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

