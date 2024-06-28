import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.CashPayment;
import com.store.onlinestore.model.service.CashPaymentService;
import java.time.LocalDateTime;

public class CashPaymentTest {

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

        System.out.println(CashPaymentService.getService().save(cashPayment1));
        System.out.println(CashPaymentService.getService().save(cashPayment2));

        System.out.println(CashPaymentService.getService().findAll());
    }
}

