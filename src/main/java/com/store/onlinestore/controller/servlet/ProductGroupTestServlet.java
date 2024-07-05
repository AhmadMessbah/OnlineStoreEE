package com.store.onlinestore.controller.servlet;

import com.store.onlinestore.model.entity.ProductGroup;

import com.store.onlinestore.model.service.ProductGroupService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(value = "/product-group-test")
public class ProductGroupTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            ProductGroup productGroup0 =
                    ProductGroup
                            .builder()
                            .name("All Types")
                            .description("----")
                            .status(true)
                            .parentGroup(null)
                            .childGroupList(null)
                            .build();

            System.out.println("Save 0 ------> " + ProductGroupService.getService().save(productGroup0));


            ProductGroup productGroup1 =
                    ProductGroup
                            .builder()
                            .name("toy")
                            .description("----")
                            .status(true)
                            .parentGroup(productGroup0)
                            .childGroupList(null)
                            .build();

            ProductGroup productGroup2 =
                    ProductGroup
                            .builder()
                            .name("+3years")
                            .description("---")
                            .status(true)
                            .parentGroup(productGroup1)
                            .childGroupList(null)
                            .build();

            ProductGroup productGroup3 =
                    ProductGroup
                            .builder()

                            .name("doll")
                            .description("---")
                            .status(true)
                            .parentGroup(productGroup2)
                            .childGroupList(null)
                            .build();

            ProductGroup productGroup4 =
                    ProductGroup
                            .builder()
                            .name("wooden")
                            .description("---")
                            .status(true)
                            .parentGroup(productGroup1)
                            .childGroupList(null)
                            .build();

            ProductGroup productGroup5 =
                    ProductGroup
                            .builder()
                            .name("electrical")
                            .description("---")
                            .status(true)
                            .parentGroup(null)
                            .childGroupList(null)
                            .build();

//            BeanValidator<ProductGroup> productGroupValidator = new BeanValidator<>();
//            if(productGroupValidator.validate(productGroup1).isEmpty()) {
//                System.out.println(ProductGroupService.getService().save(productGroup1));
//            }else{
//                System.out.println(productGroupValidator.validate(productGroup1));
//            }
//
//
//            if(productGroupValidator.validate(productGroup2).isEmpty()) {
//                System.out.println(ProductGroupService.getService().edit(productGroup2));
//            }else{
//                System.out.println(productGroupValidator.validate(productGroup2));
//            }

//            if(productGroupValidator.validate(productGroup3).isEmpty()) {
//                System.out.println(ProductGroupService.getService().save(productGroup3));
//            }else{
//                System.out.println(productGroupValidator.validate(productGroup3));
//            }




            testSave(productGroup1, productGroup0);
            testSave(productGroup2, productGroup1);
            testSave(productGroup3, productGroup2);
            testSave(productGroup4, productGroup1);
            testSave(productGroup5, null);


//            todo : Stack Overflow       بدلیل وجود رابطه یک به چند دو طرفه خطا میدهند
//            System.out.println("find all ------> " + ProductGroupService.getService().findAll());
//            System.out.println("find by name ------> " + ProductGroupService.getService().findByName("toy"));

            System.out.println("findAll, list size ------> " + ProductGroupService.getService().findAll().size());
            System.out.println("findByName, name : All types (childList size) ------> " + ProductGroupService.getService().findByName("All Types").getChildGroupList().size());
            System.out.println("findByName, name : toy (childList size) ------> " + ProductGroupService.getService().findByName("toy").getChildGroupList().size());
            System.out.println("findByName, name : +3years (childList size) ------> " + ProductGroupService.getService().findByName("+3years").getChildGroupList().size());
            System.out.println("findByParentName, parent name : All types (childList size) ------> " + ProductGroupService.getService().findByParentName("All Types").size());
            System.out.println("findById, ID:2, name : " + ProductGroupService.getService().findById(2L).getName());
            System.out.println("findByStatus, list size ------> " + ProductGroupService.getService().findByStatus(true).size());


        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    private static void testSave(ProductGroup productGroup1, ProductGroup parentGroup) throws Exception {
        if (productGroup1.getParentGroup() == null || ProductGroupService.getService().findByName(productGroup1.getParentGroup().getName()) == null) {
            parentGroup = ProductGroupService.getService().findById(1L);
            productGroup1.setParentGroup(parentGroup);
            ProductGroupService.getService().save(productGroup1);
            System.out.println("Save "+ productGroup1.getName() + " (method A) ------>  parent : " + productGroup1.getParentGroup().getName());
            parentGroup.addChildGroup(productGroup1);
            ProductGroupService.getService().edit(parentGroup);
        } else {
            ProductGroupService.getService().save(productGroup1);
            System.out.println("Save "+ productGroup1.getName() + " (method B) ------> parent : " + productGroup1.getParentGroup().getName());
            productGroup1.getParentGroup().addChildGroup(productGroup1);
            ProductGroupService.getService().edit(productGroup1.getParentGroup());
        }
    }

}
