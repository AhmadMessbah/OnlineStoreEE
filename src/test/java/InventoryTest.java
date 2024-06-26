import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Inventory;
import com.store.onlinestore.model.service.InventoryService;

import java.time.LocalDateTime;

public class InventoryTest {
    public static void main(String[] args) throws Exception {

        Inventory inventory1 = Inventory.builder()
                .InventoryName("cheese")
                .productStock(100)
                .totalStock(5000)
                .registerDate(LocalDateTime.of(2024, 6, 20, 7, 24))
                .productList(null)
                .supplierList(null)
                .build();

        Inventory inventory2 = Inventory.builder()
                .InventoryName("milk")
                .productStock(200)
                .totalStock(5000)
                .registerDate(LocalDateTime.of(2024, 6, 22, 9, 27))
                .productList(null)
                .supplierList(null)
                .build();

//        BeanValidator<Inventory> inventoryValidator = new BeanValidator<>();
//        System.out.println(inventoryValidator.validate(inventory1));
//
//        System.out.println(InventoryService.getService().save(inventory1));
//        System.out.println(InventoryService.getService().save(inventory2));
//
//        System.out.println(InventoryService.getService().findAll());
//        System.out.println(InventoryService.getService().findByName("cheese"));
    }
}
