import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.CheckPayment;
import com.store.onlinestore.model.service.CheckService;
import java.time.LocalDateTime;

public class CheckTest {
    public static void main(String[] args) throws Exception {
        CheckPayment checkPayment1 =
                CheckPayment
                    .builder()
                    .checkNumber(123456789L)
                    .dateTime(LocalDateTime.now())
                    .build();

        CheckPayment checkPayment2 =
                CheckPayment
                    .builder()
                    .checkNumber(987654321L)
                    .dateTime(LocalDateTime.now())
                    .build();

        BeanValidator<CheckPayment> CheckValidator = new BeanValidator<>();

        System.out.println(CheckValidator.validate(checkPayment1));
        System.out.println(CheckValidator.validate(checkPayment2));

        System.out.println(CheckService.getService().save(checkPayment1));
        System.out.println(CheckService.getService().save(checkPayment2));

        System.out.println(CheckService.getService().findAll());

        System.out.println(CheckService.getService().FindByCheckNumber(123456789));
    }
}
