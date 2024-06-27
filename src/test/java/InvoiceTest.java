//import com.store.onlinestore.controller.validation.BeanValidator;
//import com.store.onlinestore.model.entity.*;
//import com.store.onlinestore.model.service.InvoiceService;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//public class InvoiceTest {
//    public static void main(String[] args) throws Exception {
//        Customer customer =
//                Customer
//                        .builder()
//                        .id(2L)
//
//                        .build();
//
//        Product product1 =
//                Product
//                        .builder()
//                        .id(1L)
//                        .build();
//
//        Product product2 =
//                Product
//                        .builder()
//                        .id(1L)
//                        .build();
//
//        Invoice invoice =
//                Invoice
//                        .builder()
//                        .id(2L)
//                        .serial("A-00001")
//                        .customer(customer)
//                        .localDateTime(LocalDateTime.now())
//                        .discount(150)
//                        .build();
//
//        InvoiceItem invoiceItem1 =
//                InvoiceItem
//                        .builder()
//                        .product(product1)
//                        .count(2)
//                        .price(1000)
//                        .invoice(invoice)
//                        .build();
//
//        InvoiceItem invoiceItem2 =
//                InvoiceItem
//                        .builder()
//                        .product(product2)
//                        .count(3)
//                        .price(2500)
//                        .invoice(invoice)
//                        .build();
//
//        List<InvoiceItem> invoiceItemList = new ArrayList<>();
////            invoiceItemList.add(invoiceItem1);
//        invoiceItemList.add(invoiceItem2);
//        invoice.setInvoiceItemList(invoiceItemList);
//
//        int amount = invoice.getAmount();
//        int pureAmount = invoice.getPureAmount();
//
//        invoice.setAmount(amount);
//        invoice.setPureAmount(pureAmount);
//
//TODO هیچ کدوم اجرا نشد
//        BeanValidator<Invoice> invoiceValidator = new BeanValidator<>();
//            if (invoiceValidator.validate(invoice).isEmpty()) {
//                System.out.println(InvoiceService.getService().save(invoice));
//            } else {
//                System.out.println(invoiceValidator.validate(invoice));
//            }

//
//
//            if(invoiceValidator.validate(invoice).isEmpty()) {
//                System.out.println(InvoiceService.getService().edit(invoice));
//            }else {
//                System.out.println(invoiceValidator.validate(invoice));
//            }
//
//
//            if(invoiceValidator.validate(invoice).isEmpty()) {
//                System.out.println(InvoiceService.getService().remove(1L));
//            }else{
//                System.out.println(invoiceValidator.validate(invoice));
//            }
////
//
//            System.out.println(InvoiceService.getService().findAll());
//            System.out.println(InvoiceService.getService().findById(53L));
//            System.out.println(InvoiceService.getService().findBySerial("ab-123"));
//            System.out.println(InvoiceService.getService().findByCustomer(customer.getId()));
//            System.out.println(InvoiceService.getService().findByDate(LocalDateTime.now()));
        //TODO
//            System.out.println(InvoiceService.getService().findByRangeDate());
//
//    }
//}
//
