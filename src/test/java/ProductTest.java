import com.store.onlinestore.model.entity.Product;
import com.store.onlinestore.model.service.ProductService;

import java.sql.Time;
import java.time.LocalTime;

public class ProductTest {
    public static void main(String[] args) throws Exception {
        Product product1 =
                Product
                        .builder()
                        .name("sabon")
                        .description("sabz")
                        .status(true)
                        .brand("golnar")
                        .unitId(null)
                        .productGroupId(null)
                        .price(10000)
                        .image("/img/0001.jpg")
                        .dateOfModified(Time.valueOf(LocalTime.now()))
                        .barcode("021655632")
                        .inStock(0)
                        .build();

        Product product2 =
                Product
                        .builder()
                        .name("mooz")
                        .description("zard")
                        .status(true)
                        .brand("amrica")
                        .unitId(null)
                        .productGroupId(null)
                        .price(20000)
                        .image("/img/0002.jpg")
                        .dateOfModified(Time.valueOf(LocalTime.now()))
                        .barcode("54684")
                        .inStock(1)
                        .build();
//        todo:dar in folder kar nemikone va error JSON Binding provider org.eclipse.yasson.JsonBindingProvider not found
//        System.out.println(ProductService.getService().save(product2));
//        System.out.println(ProductService.getService().save(product1));
//        System.out.println(ProductService.getService().findAll());
//        System.out.println(ProductService.getService().findByNameAndBrand("m","a"));
//        System.out.println(ProductService.getService().FindByBrand("a"));
    }
}
