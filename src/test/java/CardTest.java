import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Card;
import com.store.onlinestore.model.service.CardService;
import java.time.LocalDateTime;

public class CardTest {
    public static void main(String[] args) throws Exception {
        Card card1 =
                Card
                        .builder()
                        .cardNumber(1451547777)
                        .cvv2(223)
                        .cardExpireDate(LocalDateTime.now())
                        .build();
        Card card2 =
                Card
                        .builder()
                        .cardNumber(5022222)
                        .cvv2(123)
                        .cardExpireDate(LocalDateTime.now())
                        .build();
        BeanValidator<Card> cardValidator = new BeanValidator<>();
        System.out.println(cardValidator.validate(card1));
        System.out.println(cardValidator.validate(card2));

        System.out.println(CardService.getService().save(card1));
        System.out.println(CardService.getService().save(card2));

        System.out.println(CardService.getService().findAll());
    }

}
