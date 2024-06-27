import com.store.onlinestore.model.entity.Product;
import com.store.onlinestore.model.service.ProductService;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ProductTest {
    public static void main(String[] args) throws Exception {
        Product product1 =
                Product
                        .builder()
                        .name("car")
                        .description("black")
                        .status(true)
                        .brand("benz")
                        .unitId(null)
                        .productGroupId(null)
                        .price(10000)
                        .dateOfModified(LocalDateTime.now())
                        .barcode("021655632")
                        .inventoryId(null)
                        .build();

        Product product2 =
                Product
                        .builder()
                        .name("laptop")
                        .description("xs55")
                        .status(true)
                        .brand("asus")
                        .unitId(null)
                        .productGroupId(null)
                        .price(20000)
                        .dateOfModified(LocalDateTime.now())
                        .barcode("54684")
                        .inventoryId(null)
                        .build();
//        todo:dar in folder kar nemikone va error JSON Binding provider org.eclipse.yasson.JsonBindingProvider not found
        System.out.println(ProductService.getService().save(product2));
        System.out.println(ProductService.getService().save(product1));
        System.out.println(ProductService.getService().findAll());
        System.out.println(ProductService.getService().findByNameAndBrand("c","b"));
        System.out.println(ProductService.getService().FindByBrand("a"));
    }
}
