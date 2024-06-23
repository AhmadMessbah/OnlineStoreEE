import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Customer;
import com.store.onlinestore.model.entity.Person;
import com.store.onlinestore.model.entity.enums.UserState;
import com.store.onlinestore.model.service.CustomerService;
import com.store.onlinestore.model.service.PersonService;


public class CustomerTest {
    public static void main(String[] args) throws Exception {

        Customer customer =
                Customer
                        .builder()
                        .name("aaaa")
                        .family("bbbb")
                        .username("cccc")
                        .password("123456789")
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
