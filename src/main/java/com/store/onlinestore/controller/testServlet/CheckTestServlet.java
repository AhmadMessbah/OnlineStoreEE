package com.store.onlinestore.controller.testServlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.CheckPayment;
import com.store.onlinestore.model.service.CheckPaymentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/Check.test")
public class CheckTestServlet extends HttpServlet {

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

            BeanValidator<CheckPayment> checkValidator = new BeanValidator<>();

            if(checkValidator.validate(checkPayment1).isEmpty()) {
                System.out.println(checkValidator.validate(checkPayment1));
            }else{
                System.out.println(checkValidator.validate(checkPayment1));
            }

            if(checkValidator.validate(checkPayment2).isEmpty()) {
                System.out.println(checkValidator.validate(checkPayment2));
            }else{
                System.out.println(checkValidator.validate(checkPayment2));
            }

            System.out.println(CheckPaymentService.getService().findAll());

            System.out.println(CheckPaymentService.getService().FindByCheckNumber(123456789));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
