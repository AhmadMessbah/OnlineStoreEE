import com.store.onlinestore.model.entity.Admin;
import com.store.onlinestore.model.service.AdminService;

public class AdminTest {
    public static void main(String[] args) throws Exception {
            Admin admin1 =
                    Admin
                            .builder()
                            .name("le")
                            .family("messbah")
                            .password("leva123")
                            .email("a@a.com")
                            .image("/img/0001.jpg")
                            .build();

            Admin admin2 =
                    Admin
                            .builder()
                            .name("ahmad")
                            .family("messbah")
                            .password("admin123")
                            .email("a2@a.com")
                            .image("/img/0002.jpg")
                            .build();

            System.out.println(AdminService.getService().save(admin1));
    }
    }
