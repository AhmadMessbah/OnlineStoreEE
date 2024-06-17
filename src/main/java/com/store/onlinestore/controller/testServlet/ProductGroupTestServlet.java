package com.store.onlinestore.controller.testServlet;

import com.store.onlinestore.controller.validation.BeanValidator;

import com.store.onlinestore.model.entity.ProductGroup;

import com.store.onlinestore.model.service.ProductGroupService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/productgroup.test")
public class ProductGroupTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
//            ProductGroup productGroup1 =
//                    ProductGroup
//                            .builder()
//                            .name("electrical")
//                            .description("220 V")
//                            .status(true)
//                            .build();
//
//            ProductGroup productGroup2 =
//                    ProductGroup
//                            .builder()
//                            .name("toy")
//                            .description("wooden")
//                            .status(true)
//                            .build();

            ProductGroup productGroup2 =
                    ProductGroup
                            .builder()
                            .id(2L)
                            .name("toy")
                            .description("+3 years")
                            .status(true)
                            .build();

//            ProductGroup productGroup3 =
//                    ProductGroup
//                            .builder()
//                            .name("33")
//                            .description("ghgfhg")
//                            .status(true)
//                            .build();

            BeanValidator<ProductGroup> productGroupValidator = new BeanValidator<>();
//            if(productGroupValidator.validate(productGroup1).isEmpty()) {
//                System.out.println(ProductGroupService.getService().save(productGroup1));
//            }else{
//                System.out.println(productGroupValidator.validate(productGroup1));
//            }
//
//
            if(productGroupValidator.validate(productGroup2).isEmpty()) {
                System.out.println(ProductGroupService.getService().edit(productGroup2));
            }else{
                System.out.println(productGroupValidator.validate(productGroup2));
            }

//            if(productGroupValidator.validate(productGroup3).isEmpty()) {
//                System.out.println(ProductGroupService.getService().save(productGroup3));
//            }else{
//                System.out.println(productGroupValidator.validate(productGroup3));
//            }

            System.out.println(ProductGroupService.getService().findAll());

            System.out.println(ProductGroupService.getService().findByName("electrical"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
