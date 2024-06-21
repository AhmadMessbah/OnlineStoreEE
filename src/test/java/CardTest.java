import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.CardPayment;
import com.store.onlinestore.model.service.CardService;
import java.time.LocalDateTime;

public class CardTest {
    public static void main(String[] args) throws Exception {
        CardPayment cardPayment1 =
                CardPayment
                        .builder()
                        .cardNumber(1451547777)
                        .cvv2(223)
                        .cardExpireDate(LocalDateTime.now())
                        .build();
        CardPayment cardPayment2 =
                CardPayment
                        .builder()
                        .cardNumber(5022222)
                        .cvv2(123)
                        .cardExpireDate(LocalDateTime.now())
                        .build();
        BeanValidator<CardPayment> cardValidator = new BeanValidator<>();
        System.out.println(cardValidator.validate(cardPayment1));
        System.out.println(cardValidator.validate(cardPayment2));

        System.out.println(CardService.getService().save(cardPayment1));
        System.out.println(CardService.getService().save(cardPayment2));

        System.out.println(CardService.getService().findAll());
    }

}
