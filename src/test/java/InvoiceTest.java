import com.store.onlinestore.model.entity.*;
import com.store.onlinestore.model.entity.enums.FileType;
import com.store.onlinestore.model.entity.enums.UserState;
import com.store.onlinestore.model.service.*;

import java.time.LocalDateTime;

public class InvoiceTest {
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

//
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

//        System.out.println(InvoiceService.getService().findAll());
        //todo WARNING: An illegal reflective access operation has occurred
        //WARNING: Illegal reflective access by com.google.gson.internal.reflect.ReflectionHelper (file:/C:/Users/Arash/.m2/repository/com/google/code/gson/gson/2.11.0/gson-2.11.0.jar) to field java.time.LocalDateTime.date
        //WARNING: Please consider reporting this to the maintainers of com.google.gson.internal.reflect.ReflectionHelper
        //WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
        //WARNING: All illegal access operations will be denied in a future release
        //Exception in thread "main" org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: com.store.onlinestore.model.entity.Invoice.invoiceItemList: could not initialize proxy - no Session
        //	at org.hibernate.collection.spi.AbstractPersistentCollection.throwLazyInitializationException(AbstractPersistentCollection.java:635)
        //	at org.hibernate.collection.spi.AbstractPersistentCollection.withTemporarySessionIfNeeded(AbstractPersistentCollection.java:218)
        //	at org.hibernate.collection.spi.AbstractPersistentCollection.initialize(AbstractPersistentCollection.java:615)
        //	at org.hibernate.collection.spi.AbstractPersistentCollection.read(AbstractPersistentCollection.java:136)
        //	at org.hibernate.collection.spi.PersistentBag.iterator(PersistentBag.java:366)
        //	at com.google.gson.internal.bind.CollectionTypeAdapterFactory$Adapter.write(CollectionTypeAdapterFactory.java:98)
        //	at com.google.gson.internal.bind.CollectionTypeAdapterFactory$Adapter.write(CollectionTypeAdapterFactory.java:59)
        //	at com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper.write(TypeAdapterRuntimeTypeWrapper.java:73)
        //	at com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$2.write(ReflectiveTypeAdapterFactory.java:247)
        //	at com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$Adapter.write(ReflectiveTypeAdapterFactory.java:490)
        //	at com.google.gson.Gson.toJson(Gson.java:944)
        //	at com.google.gson.Gson.toJson(Gson.java:899)
        //	at com.google.gson.Gson.toJson(Gson.java:848)
        //	at com.google.gson.Gson.toJson(Gson.java:825)
        //	at com.store.onlinestore.model.entity.Base.toString(Base.java:37)
        //	at java.base/java.lang.String.valueOf(String.java:2951)
        //	at java.base/java.io.PrintStream.println(PrintStream.java:897)
        //	at InvoiceTest.main(InvoiceTest.java:169)

    }
}

