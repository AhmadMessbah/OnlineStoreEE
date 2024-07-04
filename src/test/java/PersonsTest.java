import com.store.onlinestore.model.entity.*;
import com.store.onlinestore.model.entity.enums.FileType;
import com.store.onlinestore.model.entity.enums.UserState;
import com.store.onlinestore.model.service.AdminService;
import com.store.onlinestore.model.service.CustomerService;
import com.store.onlinestore.model.service.ManagerService;
import com.store.onlinestore.model.service.RoleService;

import java.time.LocalDateTime;

import static com.store.onlinestore.model.entity.Admin.builder;

public class PersonsTest {
    public static void main(String[] args) throws Exception {
        Attachment attachment1 =
                Attachment
                        .builder()
                        .filename("attach1.jpg")
                        .fileType(FileType.Jpg)
                        .localDateTime(LocalDateTime.now())
                        .build();

        Attachment attachment2 =
                Attachment
                        .builder()
                        .filename("attach2.jpg")
                        .fileType(FileType.Jpg)
                        .localDateTime(LocalDateTime.now())
                        .build();

        Role adminRole = Role.builder().role("admin").build();
        System.out.println(RoleService.getService().save(adminRole));

        Role customerRole = Role.builder().role("customer").build();
        System.out.println(RoleService.getService().save(customerRole));

        Role managerRole = Role.builder().role("manager").build();
        System.out.println(RoleService.getService().save(managerRole));

   /**     Address address = Address
                .builder()
                .countryName("Iran")
                .stateName("Tehran")
                .cityName("Tehran")
                .build();
        System.out.println(AddressService.getService().addressSave(address));
*/
        Admin admin =
                builder()
                        .name("leva")
                        .family("ziaei")
                        .username("Levaziaeii")
                        .password("admin123")
                        .nationalCode("0111234575")
                        .status(UserState.Active)
//                        .address(address)
                        .build();
        admin.addAttachment(attachment1);
        admin.addAttachment(attachment2);

        System.out.println(AdminService.getService().save(admin));

        Customer customer =
                Customer
                        .builder()
                        .name("aaaa")
                        .family("bbbb")
                        .username("cccc")
                        .password("123456789")
                        .email("aaa@gmail.com")
                        .phoneNumber("09121234567")
                        .nationalCode("0111234575")
                        .status(UserState.Active)
//                        .address(address)
                        .build();


        System.out.println(CustomerService.getService().save(customer));

        Manager manager =
                Manager
                        .builder()
                        .name("aaaa")
                        .family("bbbb")
                        .username("cccc")
                        .password("123456789")
                        .email("aaa@gmail.com")
                        .phoneNumber("09121234567")
                        .nationalCode("0111234575")
                        .status(UserState.Active)
//                        .address(address)
                        .build();

        System.out.println(ManagerService.getService().save(manager));
    }
}
