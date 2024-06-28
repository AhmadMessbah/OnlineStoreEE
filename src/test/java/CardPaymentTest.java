import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.CardPayment;
import com.store.onlinestore.model.service.CardPaymentService;
import java.time.LocalDateTime;

public class CardPaymentTest {

    public static void main(String[] args) throws Exception {

        CardPayment cardPayment1 =
                CardPayment
                        .builder()
                        .cardNumber(1451547777L)
                        .paymentDateTime(LocalDateTime.now())
                        .build();

        CardPayment cardPayment2 =
                CardPayment
                        .builder()
                        .cardNumber(5022222L)
                        .paymentDateTime(LocalDateTime.now())
                        .build();

        BeanValidator<CardPayment> cardValidator = new BeanValidator<>();

        System.out.println(cardValidator.validate(cardPayment1));
        System.out.println(cardValidator.validate(cardPayment2));

        System.out.println(CardPaymentService.getService().save(cardPayment1));
        System.out.println(CardPaymentService.getService().save(cardPayment2));

        System.out.println(CardPaymentService.getService().findAll());

        System.out.println(CardPaymentService.getService().FindByCardNumber(5022222));
    }

}
