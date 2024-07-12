import com.store.onlinestore.model.entity.*;
import com.store.onlinestore.model.entity.enums.FileType;
import com.store.onlinestore.model.entity.enums.UserState;
import com.store.onlinestore.model.service.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InventoryTest {
    public static void main(String[] args) throws Exception {
        Role customerRole = Role.builder().role("customer").build();
//        System.out.println(RoleService.getService().save(customerRole));

        Customer customer =
                Customer
                        .builder()
                        .name("aaaa")
                        .family("bbbb")
//                        .username("cccc")
//                        .password("123456789")
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

//        ProductUnitService.getService().save(unit1);
//        ProductUnitService.getService().save(unit2);
//        System.out.println(ProductUnitService.getService().findAll());

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

//        InvoiceItemService.getService().save(invoiceItem1);
//        InvoiceItemService.getService().save(invoiceItem2);

//        invoice.setInvoiceItemList(new ArrayList<InvoiceItem>());
//        invoice.getInvoiceItemList().add(invoiceItem1);
//        invoice.getInvoiceItemList().add(invoiceItem2);
//        InvoiceService.getService().edit(invoice);

        invoice.addItem(invoiceItem1);
        invoice.addItem(invoiceItem2);

//        InvoiceService.getService().edit(invoice);

        Supplier supplier1=Supplier.builder()
//                .name("Supplier1 name")
//                .family("Supplier1 family")
//                .mobilePhone("09171711111")
//                .nationalCode("34934934900")
//                .email("abcd@gmail.com")
                .companyName("ramak")
                .build();

        Supplier supplier2=Supplier.builder()
//                .name("Supplier2 name")
//                .family("Supplier2 family")
//                .mobilePhone("09171700000")
//                .nationalCode("34934934911")
//                .email("efgh@gmail.com")
                .companyName("kale")
                .build();

        List<Supplier> supplierList1=new ArrayList<>();
        supplierList1.add(supplier1);

        List<Supplier> supplierList2=new ArrayList<>();
        supplierList1.add(supplier2);


        Inventory inventory1=Inventory.builder()
                .description("This is Inventory1 des")
//                .productStock(20)
                .product(product1)
//                .supplierList(supplierList1)
                .build();

        Inventory inventory2=Inventory.builder()
                .description("This is Inventory2 des")
//                .productStock(11)
                .product(product2)
//                .supplierList(supplierList2)
                .build();

//        System.out.println(InventoryService.getService().save(inventory1));
//        System.out.println(InventoryService.getService().save(inventory2));
//
//        System.out.println(InventoryService.getService().findAll());

    }
}

