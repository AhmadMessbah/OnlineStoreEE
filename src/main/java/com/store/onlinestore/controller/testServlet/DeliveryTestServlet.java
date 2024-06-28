package com.store.onlinestore.controller.testServlet;


import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Delivery;
import com.store.onlinestore.model.entity.enums.DeliveryStatus;
import com.store.onlinestore.model.service.DeliveryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delivery.test")
public class DeliveryTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Delivery delivery1 = Delivery.builder()
                    .orderId("abcdhdsfshhadssd")
                    .receiverName("Mehrdad")
                    .description("hdsk hkfsdl s sajoi#$%@%$#@$*/-/+")
                    .build();
            Delivery delivery2 = Delivery.builder()
                    .orderId("abcdhdsfshha n")
                    .receiverName("_Abbas")
                    .description("hdsk hkfsdl s sajoi#$%@%$#@$*/-/+")
                    .build();
            Delivery delivery3 = Delivery.builder()
                    .orderId("asdfghjkl")
                    .receiverName("Behroz")
                    .description("hdsk hkfsdl s sajoi#$%@%$#@$*/-/+")
                    .build();
            Delivery delivery4 = Delivery.builder()
                    .orderId("abc dhshha")
                    .receiverName("Mohammad")
                    .description("hdsk hkfsdl s sajoi#$%@%$#@$*/-/+")
                    .build();
            BeanValidator<Delivery> deliveryValidator = new BeanValidator<>();
            if (!(deliveryValidator.validate(delivery1).isEmpty())) {
                DeliveryService.getDeliveryService().deliverySave(delivery1);
            } else {
                System.out.println(deliveryValidator.validate(delivery1));
            }
            if (!(deliveryValidator.validate(delivery2).isEmpty())) {
                DeliveryService.getDeliveryService().deliverySave(delivery2);
            } else {
                System.out.println(deliveryValidator.validate(delivery2));
            }
            if (!(deliveryValidator.validate(delivery3).isEmpty())) {
                DeliveryService.getDeliveryService().deliverySave(delivery3);
            } else {
                System.out.println(deliveryValidator.validate(delivery3));
            }
            if (!(deliveryValidator.validate(delivery4).isEmpty())) {
                DeliveryService.getDeliveryService().deliverySave(delivery4);
            } else {
                System.out.println(deliveryValidator.validate(delivery4));
            }
            System.out.println(DeliveryService.getDeliveryService().deliveryFindAll());
            System.out.println(DeliveryService.getDeliveryService().deliveryFindById(1L));
            System.out.println(DeliveryService.getDeliveryService().deliveryFindByDeliveryStatus(DeliveryStatus.SENDING));
         //   System.out.println(DeliveryService.getDeliveryService().deliveryFindByNameAndFamily("ali", "alipour"));
            System.out.println(DeliveryService.getDeliveryService().deliveryFindByOrderId("asdfghjkl"));
            System.out.println(DeliveryService.getDeliveryService().deliveryFindByReceiverName("Mohammad"));
            if (!(deliveryValidator.validate(delivery1).isEmpty())) {
                DeliveryService.getDeliveryService().deliveryEdit(delivery1);
            } else {
                System.out.println(deliveryValidator.validate(delivery1));
            }
            System.out.println(DeliveryService.getDeliveryService().deliveryFindAll());
//            DeliveryService.getDeliveryService().deliverySave(delivery1);
//            DeliveryService.getDeliveryService().deliverySave(delivery2);
//            DeliveryService.getDeliveryService().deliverySave(delivery3);
//            DeliveryService.getDeliveryService().deliverySave(delivery4);
//            DeliveryService.getDeliveryService().deliveryFindAll();
//            DeliveryService.getDeliveryService().deliveryFindById(1L);
//            DeliveryService.getDeliveryService().deliveryFindByDeliveryStatus(DeliveryStatus.SENDING);
//            DeliveryService.getDeliveryService().deliveryFindByName("ali");
//            DeliveryService.getDeliveryService().deliveryFindByFamily("alipour");
//            DeliveryService.getDeliveryService().deliveryFindByNameAndFamily("ali", "alipour");
//            DeliveryService.getDeliveryService().deliveryFindByOrderId("asdfghjkl");
//            DeliveryService.getDeliveryService().deliveryFindByReceiverName("Mohammad");
//            DeliveryService.getDeliveryService().deliveryFindAll();
//            DeliveryService.getDeliveryService().deliveryFindAll();
//            DeliveryService.getDeliveryService().deliveryRemove(2L);
//            DeliveryService.getDeliveryService().deliveryRemove(1L);
//            DeliveryService.getDeliveryService().deliveryFindAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

