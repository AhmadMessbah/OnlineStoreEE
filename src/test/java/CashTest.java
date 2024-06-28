import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.CashPayment;
import com.store.onlinestore.model.service.CashService;
import java.time.LocalDateTime;

public class CashTest {

    public static void main(String[] args) throws Exception {

        CashPayment cashPayment1 =
               CashPayment
                        .builder()
                        .localDateTime(LocalDateTime.now())
                        .build();

        CashPayment cashPayment2 =
                CashPayment
                        .builder()
                        .localDateTime(LocalDateTime.now())
                        .build();

        BeanValidator<CashPayment> cardValidator = new BeanValidator<>();

        System.out.println(cardValidator.validate(cashPayment1));
        System.out.println(cardValidator.validate(cashPayment2));

        System.out.println(CashService.getService().save(cashPayment1));
        System.out.println(CashService.getService().save(cashPayment2));

        System.out.println(CashService.getService().findAll());
    }
}

