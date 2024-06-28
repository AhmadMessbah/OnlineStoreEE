import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Customer;
import com.store.onlinestore.model.entity.enums.UserState;
import com.store.onlinestore.model.service.CustomerService;


public class CustomerTest {
    public static void main(String[] args) throws Exception {

        Customer customer =
                Customer
                        .builder()
                        .name("aaaa")
                        .family("bbbb")
                        .username("cccc")
                        .password("123456789")
                        .email("aaa@gmail.com")
                        .phoneNumber("09121234567")
                        .status(UserState.Active)
                        .build();

//        BeanValidator<Customer> customerValidator = new BeanValidator<>();
//        System.out.println(customerValidator.validate(customer));
//
        System.out.println(CustomerService.getService().save(customer));
//
        System.out.println(CustomerService.getService().findAll());
//
//        System.out.println(CustomerService.getService().findByUsernameAndPassword("a","11111"));
    }

}
