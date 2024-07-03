import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.*;
import com.store.onlinestore.model.entity.enums.FileType;
import com.store.onlinestore.model.entity.enums.UserState;
import com.store.onlinestore.model.service.*;

import java.time.LocalDateTime;

public class InventoryTransactionTest {
    public static void main(String[] args) throws Exception {

        Role customerRole = Role.builder().role("customer").build();
        System.out.println(RoleService.getService().save(customerRole));

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

        CustomerService.getService().save(customer);

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

        ProductGroupService.getService().save(root);
        ProductGroupService.getService().save(child1);
        ProductGroupService.getService().save(child2);
        ProductGroupService.getService().save(child3);
        ProductGroupService.getService().save(child4);

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


        Product savedP1=ProductService.getService().save(product1);
        Product savedP2=ProductService.getService().save(product2);

        Invoice invoice =
                Invoice
                        .builder()
                        .customer(customer)
                        .build();

        InvoiceService.getService().save(invoice);

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

        InvoiceService.getService().edit(invoice);

        InventoryTransaction inventoryTransaction1 = InventoryTransaction.builder()
                .registerDateTime(LocalDateTime.of(2024, 6, 22, 7, 7))
                .productId(savedP1)
                .transactionType("ENTERING")
                .deliveryPerson(null)
                .receiverPerson(null)
                .build();

        InventoryTransaction inventoryTransaction2 = InventoryTransaction.builder()
                .registerDateTime(LocalDateTime.of(2024, 6, 23, 7, 10))
                .productId(savedP2)
                .transactionType("ENTERING")
                .deliveryPerson(null)
                .receiverPerson(null)
                .build();

        System.out.println(InventoryTransactionService.getService().save(inventoryTransaction1));
        System.out.println(InventoryTransactionService.getService().save(inventoryTransaction2));

        System.out.println(InventoryTransactionService.getService().findByProductId(savedP1.getId()));
        System.out.println(InventoryTransactionService.getService().findAll());
        System.out.println(InventoryTransactionService.getService().findByTransactionType("ENTERING"));
    }
}
