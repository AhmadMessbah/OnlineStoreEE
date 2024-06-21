import com.store.onlinestore.model.entity.Admin;
import com.store.onlinestore.model.service.AdminService;

public class AdminTest {
    public static void main(String[] args) throws Exception {
            Admin admin1 =
                    Admin
                            .builder()
                            .name("leva")
                            .family("ziaee")
                            .password("admin123")
                            .email("a@a.com")
                            .image("/img/0001.jpg")
                            .build();

            System.out.println(AdminService.getService().save(admin1));
    }
    }
