package com.store.onlinestore.controller.servlet;

import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Address;
import com.store.onlinestore.model.service.AddressService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/address.do")
public class AddressServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Address address1 = Address
                    .builder()
                    .countryName(req.getParameter("country"))
                    .stateName("_tehran-")
                    .cityName("by=")
                    .villageName("razi conan}{")
                    .regionName("mantaghe 22")
                    .streetName("2566 ehjab hhhkjafd (bxcb) !")
                    .platesNumber("A21")
                    .floorNumber("18/")
                    .homeUnit("4*")
                    .postalCode("46464654646464646")
                    .build();

            Address address2 = Address
                    .builder()
                    .countryName("Iran")
                    .stateName("Tehran")
                    .cityName("Tehran")
                    .villageName(null)
                    .regionName("22")
                    .streetName("PeykanShahr")
                    .platesNumber("145")
                    .floorNumber("3")
                    .homeUnit("3")
                    .postalCode("4646464646")
                    .build();
            Address address3 = Address
                    .builder()
                    .countryName("USA")
                    .stateName("Texas")
                    .cityName(null)
                    .villageName("Did")
                    .regionName("22")
                    .streetName("Green 2")
                    .platesNumber("145")
                    .floorNumber(null)
                    .homeUnit(null)
                    .postalCode("7894561237")
                    .build();

            BeanValidator<Address> addressValidator = new BeanValidator<>();
            if (!(addressValidator.validate(address1).isEmpty())) {
                AddressService.getService().save(address1);
            } else {
                System.out.println(addressValidator.validate(address1));
            }
            if (!(addressValidator.validate(address2).isEmpty())) {
                AddressService.getService().save(address2);
            } else {
                System.out.println(addressValidator.validate(address2));
            }
            if (!(addressValidator.validate(address3).isEmpty())) {
                AddressService.getService().save(address3);
            } else {
                System.out.println(addressValidator.validate(address3));
            }
            System.out.println(AddressService.getService().findAll());
            System.out.println(AddressService.getService().findById(1L));
            System.out.println(AddressService.getService().findByPostalCode("4646464646"));
            System.out.println(AddressService.getService().findByCountryAndState("USA", "Texas"));
            if (!(addressValidator.validate(address3).isEmpty())) {
                AddressService.getService().edit(address3);
            } else {
                System.out.println(addressValidator.validate(address3));
            }
            System.out.println(AddressService.getService().findAll());
//            AddressService.getService().addressSave(address1);
//            AddressService.getService().addressSave(address2);
//            AddressService.getService().addressFindAll();
//            AddressService.getService().addressFindById(1L);
//            AddressService.getService().addressFindByCountryAndState("Iran","Tehran");
//            AddressService.getService().addressFindByPostalCode("4646464646");
//            AddressService.getService().addressRemove(2L);
//            AddressService.getService().addressRemove(1L);
//            AddressService.getService().addressFindAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

