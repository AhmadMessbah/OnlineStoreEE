import com.store.onlinestore.model.entity.Customer;
import com.store.onlinestore.model.entity.Manager;
import com.store.onlinestore.model.entity.enums.UserState;
import com.store.onlinestore.model.service.CustomerService;
import com.store.onlinestore.model.service.ManagerService;

public class ManagerTest {
    public static void main(String[] args) throws Exception {

        Manager manager =
                Manager
                        .builder()
                        .name("aaaa")
                        .family("bbbb")
                        .username("cccc")
                        .password("123456789")
                        .email("aaa@gmail.com")
                        .phoneNumber("09121234567")
                        .status(UserState.Active)
                        .build();

//        BeanValidator<Manager> managerValidator = new BeanValidator<>();
//        System.out.println(managerValidator.validate(manager));
//
        System.out.println(ManagerService.getService().save(manager));
//
        System.out.println(ManagerService.getService().findAll());
//
//        System.out.println(ManagerService.getService().findByUsernameAndPassword("a","11111"));
    }
}
