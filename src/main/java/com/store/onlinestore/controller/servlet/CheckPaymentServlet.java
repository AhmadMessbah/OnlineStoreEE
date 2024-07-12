package com.store.onlinestore.controller.servlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import jakarta.servlet.annotation.HttpMethodConstraint;
import com.store.onlinestore.model.entity.CheckPayment;
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

@WebServlet("/Check.do")
public class CheckPaymentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            CheckPayment checkPayment1 =
                CheckPayment
                    .builder()
                    .checkNumber(123456789L)
                    .paymentDateTime(LocalDateTime.now())
                    .build();

            CheckPayment checkPayment2 =
                CheckPayment
                    .builder()
                    .checkNumber(987654321L)
                    .paymentDateTime(LocalDateTime.now())
                    .build();

            // todo : Error check payment service
            BeanValidator<CheckPayment> checkPaymentBeanValidator = new BeanValidator<>();
            if (checkPaymentBeanValidator.validate(checkPayment1).isEmpty()) {
//                System.out.println(CheckPaymentService.getService.save(checkPayment1));
            } else {
                System.out.println(checkPaymentBeanValidator.validate(checkPayment1));
            }

//            System.out.println(CheckPaymentService.getService().save(checkPayment2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
