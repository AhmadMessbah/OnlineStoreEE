import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.InventoryTransaction;
import com.store.onlinestore.model.service.InventoryTransactionService;

import java.time.LocalDateTime;

public class InventoryTransactionTest {
    public static void main(String[] args) throws Exception {

        InventoryTransaction inventoryTransaction1 = InventoryTransaction.builder()
                .registerDateTime(LocalDateTime.of(2024, 6, 22, 7, 7))
                .unit(null)
                .group(null)
                .productList(null)
                .deliveryPerson(null)
                .receiverPerson(null)
                .build();

        InventoryTransaction inventoryTransaction2 = InventoryTransaction.builder()
                .registerDateTime(LocalDateTime.of(2024, 6, 23, 7, 10))
                .unit(null)
                .group(null)
                .productList(null)
                .deliveryPerson(null)
                .receiverPerson(null)
                .build();

        BeanValidator<InventoryTransaction> inventoryTransactionValidator = new BeanValidator<>();
        System.out.println(inventoryTransactionValidator.validate(inventoryTransaction1));
        System.out.println(inventoryTransactionValidator.validate(inventoryTransaction2));

        System.out.println(InventoryTransactionService.getService().save(inventoryTransaction1));
        System.out.println(InventoryTransactionService.getService().save(inventoryTransaction2));

//        System.out.println(InventoryTransactionService.getService().findByDeliverPerson("ali","alipoor"));
        System.out.println(InventoryTransactionService.getService().findAll());
//        System.out.println(InventoryTransactionService.getService().findByPhoneNumber("09177712424"));
    }
}
