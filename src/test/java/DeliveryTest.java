import com.store.onlinestore.model.entity.*;
import com.store.onlinestore.model.entity.enums.DeliveryStatus;
import com.store.onlinestore.model.entity.enums.FileType;
import com.store.onlinestore.model.entity.enums.UserState;
import com.store.onlinestore.model.service.*;

import java.time.LocalDateTime;

public class DeliveryTest {
    public static void main(String[] args) throws Exception {
        Role customerRole = Role.builder().role("customer").build();
//        System.out.println(RoleService.getService().save(customerRole));

        Customer customer =
                Customer
                        .builder()
                        .name("aaaa")
                        .family("bbbb")
                        .username("cccc")
                        .password("123456789")
                        .email("aaa@gmail.com")
                        .phoneNumber("09121234567")
                        .status(UserState.Active)
//                        .address(address)
                        .build();

//        CustomerService.getService().save(customer);

        Attachment attachment1 =
                Attachment
                        .builder()
                        .filename("attach1.jpg")
                        .fileType(FileType.Jpg)
                        .localDateTime(LocalDateTime.now())
                        .build();

        Attachment attachment2 =
                Attachment
                        .builder()
                        .filename("attach2.jpg")
                        .fileType(FileType.Jpg)
                        .localDateTime(LocalDateTime.now())
                        .build();

        ProductUnit unit1 =
                ProductUnit
                        .builder()
                        .name("adad")
                        .build();

        ProductUnit unit2 =
                ProductUnit
                        .builder()
                        .name("Cm")
                        .build();

        ProductUnitService.getService().save(unit1);
        ProductUnitService.getService().save(unit2);
        System.out.println(ProductUnitService.getService().findAll());

        ProductGroup root =
                ProductGroup
                        .builder()
                        .name("mobile")
                        .parentGroup(null)
                        .status(true)
                        .build();

        ProductGroup child1 =
                ProductGroup
                        .builder()
                        .name("samsung")
                        .parentGroup(root)
                        .status(true)
                        .build();

        ProductGroup child2 =
                ProductGroup
                        .builder()
                        .name("apple")
                        .parentGroup(root)
                        .status(true)
                        .build();

        ProductGroup child3 =
                ProductGroup
                        .builder()
                        .name("5S")
                        .parentGroup(child2)
                        .status(true)
                        .build();

        ProductGroup child4 =
                ProductGroup
                        .builder()
                        .name("A21")
                        .parentGroup(child1)
                        .status(true)
                        .build();
//
//        ProductGroupService.getService().save(root);
//        ProductGroupService.getService().save(child1);
//        ProductGroupService.getService().save(child2);
//        ProductGroupService.getService().save(child3);
//        ProductGroupService.getService().save(child4);

        Product product1 =
                Product
                        .builder()
                        .name("mobile")
                        .barcode("iphone5S")
                        .unit(unit1)
                        .productGroup(child3)
                        .build();

        Product product2 =
                Product
                        .builder()
                        .name("mobile")
                        .barcode("A21")
                        .unit(unit1)
                        .productGroup(child4)
                        .build();


//        ProductService.getService().save(product1);
//        ProductService.getService().save(product2);

        Invoice invoice =
                Invoice
                        .builder()
                        .customer(customer)
                        .build();

//        InvoiceService.getService().save(invoice);

        InvoiceItem invoiceItem1 =
                InvoiceItem
                        .builder()
                        .product(product1)
                        .count(2)
                        .price(1000)
                        .invoice(invoice)
                        .build();


        InvoiceItem invoiceItem2 =
                InvoiceItem
                        .builder()
                        .product(product2)
                        .count(3)
                        .price(800)
                        .invoice(invoice)
                        .build();

        InvoiceItemService.getService().save(invoiceItem1);
        InvoiceItemService.getService().save(invoiceItem2);

//        invoice.setInvoiceItemList(new ArrayList<InvoiceItem>());
//        invoice.getInvoiceItemList().add(invoiceItem1);
//        invoice.getInvoiceItemList().add(invoiceItem2);
//        InvoiceService.getService().edit(invoice);

        invoice.addItem(invoiceItem1);
        invoice.addItem(invoiceItem2);

//        InvoiceService.getService().edit(invoice);

        DeliveryService deliveryService = DeliveryService.getDeliveryService();
        Delivery delivery1 = Delivery.builder()
                .orderId("abcdhdsfshhadssd")
                .receiverName("Mehrdad")
                .description("hdsk hkfsdl s sajoi#$%@%$#@$*/-/+")
                .build();
        Delivery delivery2 = Delivery.builder()
                .orderId("abcdhdsfshha n")
                .receiverName("_Abbas")
                .description("hdsk hkfsdl s sajoi#$%@%$#@$*/-/+")
                .build();
        Delivery delivery3 = Delivery.builder()
                .orderId("asdfghjkl")
                .receiverName("Behroz")
                .description("hdsk hkfsdl s sajoi#$%@%$#@$*/-/+")
                .build();
        Delivery delivery4 = Delivery.builder()
                .orderId("abc dhshha")
                .receiverName("Mohammad")
                .description("hdsk hkfsdl s sajoi#$%@%$#@$*/-/+")
                .build();
        deliveryService.save(delivery1);
        deliveryService.save(delivery2);
        deliveryService.save(delivery3);
        deliveryService.save(delivery4);
        System.out.println(deliveryService.findAll());
        System.out.println(deliveryService.findById(1L));
        System.out.println(deliveryService.findByDeliveryStatus(DeliveryStatus.SENDING));
      //  System.out.println(deliveryService.deliveryFindByNameAndFamily("ali", "alipour"));
        System.out.println(deliveryService.findByOrderId("asdfghjkl"));
        System.out.println(deliveryService.findByReceiverName("Mohammad"));
        System.out.println(deliveryService.findAll());
        System.out.println(deliveryService.findAll());
        deliveryService.remove(2L);
        deliveryService.remove(1L);
        System.out.println(deliveryService.findAll());
    }
}
