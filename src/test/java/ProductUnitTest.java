import com.store.onlinestore.model.entity.ProductUnit;
import com.store.onlinestore.model.service.ProductUnitService;

public class ProductUnitTest {
    public static void main(String[] args) throws Exception{
        ProductUnit productUnit1 = ProductUnit.builder()
                .name("eee")
                .symbol("kg")
                .description("aaaa")
                .build();

        ProductUnit productUnit2 = ProductUnit.builder()
                .name("rrr")
                .symbol("ml")
                .description("ssss")
                .build();

//        BeanValidator<ProductUnit> personValidator = new BeanValidator<>();
//        System.out.println(personValidator.validate(productUnit1));
//        System.out.println(personValidator.validate(productUnit2));

        System.out.println(ProductUnitService.getService().save(productUnit1));
//        System.out.println(ProductUnitService.getService().save(productUnit2));

//        System.out.println(ProductUnitService.getService().findAll());

//        System.out.println(ProductUnitService.getService().findByName("k"));
        }
}
