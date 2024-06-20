package com.store.onlinestore.controller.testServlet;
import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Card;
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
        try{
            Card card1 =
                    Card
                            .builder()
                            .cardNumber(1451547777)
                            .cvv2(223)
                            .cardExpireDate(LocalDateTime.now())
                            .build();
 Card card2 =
                    Card
                            .builder()
                            .cardNumber(5022222)
                            .cvv2(123)
                            .cardExpireDate(LocalDateTime.now())
                            .build();

            BeanValidator<Card> cardValidator = new BeanValidator<>();
            if(cardValidator.validate(card1).isEmpty()) {
                System.out.println(cardValidator.validate(card1));
            }else{
                System.out.println(cardValidator.validate(card1));
            }


            if(cardValidator.validate(card2).isEmpty()) {
                System.out.println(cardValidator.validate(card2));
            }else{
                System.out.println(cardValidator.validate(card2));
            }

            System.out.println(CardService.getService().findAll());

            System.out.println(CardService.getService().FindByCardNumber(5022222));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}


