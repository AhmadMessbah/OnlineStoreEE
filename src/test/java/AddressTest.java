import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Address;
import com.store.onlinestore.model.service.AddressService;

public class AddressTest {
    public static void main(String[] args) throws Exception{
        AddressService addressService = AddressService.getService();

        Address address1= Address
                .builder()
                .countryName("$%German")
                .stateName("_tehrann-")
                .cityName("by=")
                .villageName("razi conan}{")
                .regionName("mantaghe 22")
                .streetName("2566 ehjab hhhkjafd (bxcb) !")
                .platesNumber("A21")
                .floorNumber("18/")
                .homeUnit("4*")
                .postalCode("46464654646464646")
                .build();

        Address address2= Address
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

        addressService.save(address1);
        addressService.save(address2);
        System.out.println(addressService.findAll());
        System.out.println(addressService.findById(1L));
        System.out.println(addressService.findByCountryAndState("Iran", "Tehran"));
        System.out.println(addressService.findByPostalCode("4646464646"));
        addressService.remove(2L);
        addressService.remove(1L);
        System.out.println(addressService.findAll());

    }
}