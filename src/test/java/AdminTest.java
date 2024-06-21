import com.store.onlinestore.model.entity.Admin;
import com.store.onlinestore.model.entity.enums.UserState;
import com.store.onlinestore.model.service.AdminService;

import static com.store.onlinestore.model.entity.Admin.*;
import static com.store.onlinestore.model.entity.enums.UserState.Active;

public class AdminTest {
    public static void main(String[] args) throws Exception {

        Admin admin1 =
                    builder()
                            .name("leva")
                            .family("ziaei")
                            .username("Levaziaeii")
                            .password("admin123")
                            .status(Active)
                            .deleted(false)
                            .build();

            System.out.println(AdminService.getService().save(admin1));
    }
    }
