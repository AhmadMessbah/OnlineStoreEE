import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.InvoiceItem;
import com.store.onlinestore.model.entity.Person;
import com.store.onlinestore.model.service.InvoiceItemService;
import com.store.onlinestore.model.service.PersonService;

public class InvoiceItemTest {
    public static void main(String[] args) throws Exception {
        InvoiceItem invoiceItem1=
                InvoiceItem
                        .builder()
                        .count(100)
                        .price(1000)
                        .build();


        InvoiceItem invoiceItem2=
                InvoiceItem
                        .builder()
                        .count(200)
                        .price(2000)
                        .build();
        BeanValidator<InvoiceItem> invoiceItemBeanValidator = new BeanValidator<>();
        System.out.println(invoiceItemBeanValidator.validate(invoiceItem1));
        System.out.println(invoiceItemBeanValidator.validate(invoiceItem2));

        System.out.println(InvoiceItemService.getService().save(invoiceItem1));
        System.out.println(InvoiceItemService.getService().save(invoiceItem2));

        System.out.println(InvoiceItemService.getService().findAll());

    }
}
