import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.*;
import com.store.onlinestore.model.service.InvoiceService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InvoiceTest {
    public static void main(String[] args) throws Exception {
        Customer customer =
                Customer
                        .builder()
                        .name("Arash")
                        .family("Oloomi")
//                            .phoneNumber("123456")
                        .email("a@a.com")
                        .image("/img/0001.jpg")
                        .build();

        Product product1 =
                Product
                        .builder()
                        .name("mobile")
                        .brand("samsung")
                        .build();

        Product product2 =
                Product
                        .builder()
                        .name("laptop")
                        .brand("Asus")
                        .build();

        Product product3 =
                Product
                        .builder()
                        .name("monitor")
                        .brand("lg")
                        .build();

        InvoiceItem invoiceItem1 =
                InvoiceItem
                        .builder()
                        .product(product1)
                        .count(2)
                        .price(1000)
                        .build();

        InvoiceItem invoiceItem2 =
                InvoiceItem
                        .builder()
                        .product(product2)
                        .count(3)
                        .price(2500)
                        .build();

        InvoiceItem invoiceItem3 =
                InvoiceItem
                        .builder()
                        .count(5)
                        .price(500)
                        .product(product3)
                        .build();

        List<InvoiceItem> invoiceItemList = new ArrayList<>();
        invoiceItemList.add(invoiceItem1);
        invoiceItemList.add(invoiceItem2);
        invoiceItemList.add(invoiceItem3);

        Invoice invoice =
                Invoice
                        .builder()
                        .serial("A-00001")
                        .customer(customer)
                        .invoiceItemList(invoiceItemList)
//                            .discount(100)
                        .localDateTime(LocalDateTime.now())
                        .build();

        BeanValidator<Invoice> invoiceValidator = new BeanValidator<>();
//        System.out.println(invoiceValidator.validate(invoice));

        System.out.println(InvoiceService.getService().save(invoice));

    }
}

