import com.store.onlinestore.model.entity.*;
import com.store.onlinestore.model.entity.enums.FileType;
import com.store.onlinestore.model.entity.enums.UserState;
import com.store.onlinestore.model.service.*;

import java.time.LocalDateTime;

public class PaymentTest {
    public static void main(String[] args) throws Exception {
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


        Role customerRole = Role.builder().role("customer").build();
        // todo : error get service
//        RoleService.getService().save(customerRole);

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

          // todo : error get service
//        CustomerService.getService().save(customer);


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

          //todo : error get service
//        CardPaymentService.getService().save(cardPayment1);
//        CardPaymentService.getService().save(cardPayment2);
//        System.out.println(CardPaymentService.getService().findAll());


        CashPayment cashPayment1 =
                CashPayment
                        .builder()
                        .paymentDateTime(LocalDateTime.now())
                        .build();

        CashPayment cashPayment2 =
                CashPayment
                        .builder()
                        .paymentDateTime(LocalDateTime.now())
                        .build();

        //todo : error get service
//        CashPaymentService.getService().save(cashPayment1);
//        CashPaymentService.getService().save(cashPayment2);
//
//        System.out.println(CashPaymentService.getService().findAll());

        CheckPayment checkPayment1 =
                CheckPayment
                        .builder()
                        .checkNumber(123456789L)
                        .paymentDateTime(LocalDateTime.now())
                        .build();

        CheckPayment checkPayment2 =
                CheckPayment
                        .builder()
                        .checkNumber(987654321L)
                        .paymentDateTime(LocalDateTime.now())
                        .build();
        //todo : error get service
//        CheckPaymentService.getService().save(checkPayment1);
//        CheckPaymentService.getService().save(checkPayment2);
//
//        System.out.println(CheckPaymentService.getService().findAll());

        PaymentTransaction paymentTransaction =
                PaymentTransaction
                        .builder()
                        .customer(customer)
                        .build();

        paymentTransaction.addAttachment(attachment1);
        paymentTransaction.addAttachment(attachment2);
        paymentTransaction.addCardPayment(cardPayment1);
        paymentTransaction.addCardPayment(cardPayment2);
        paymentTransaction.addCashPayment(cashPayment1);
        paymentTransaction.addCashPayment(cashPayment2);
        paymentTransaction.addCheckPayment(checkPayment1);
        paymentTransaction.addCheckPayment(checkPayment2);

        System.out.println(PaymentTransactionService.getService().save(paymentTransaction));


//        System.out.println(PaymentTransactionService.getService().edit(paymentTransaction));

    }
}
