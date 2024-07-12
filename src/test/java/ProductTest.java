import com.store.onlinestore.model.entity.Attachment;
import com.store.onlinestore.model.entity.Product;
import com.store.onlinestore.model.entity.ProductGroup;
import com.store.onlinestore.model.entity.ProductUnit;
import com.store.onlinestore.model.entity.enums.FileType;
import com.store.onlinestore.model.service.ProductGroupService;
import com.store.onlinestore.model.service.ProductService;
import com.store.onlinestore.model.service.ProductUnitService;

import jakarta.inject.Inject;
import java.time.LocalDateTime;

public class ProductTest {

    public static void main(String[] args) throws Exception {
//        Attachment attachment1 =
//                Attachment
//                        .builder()
//                        .filename("attach1.jpg")
//                        .fileType(FileType.Jpg)
//                        .localDateTime(LocalDateTime.now())
//                        .build();
//
//        Attachment attachment2 =
//                Attachment
//                        .builder()
//                        .filename("attach2.jpg")
//                        .fileType(FileType.Jpg)
//                        .localDateTime(LocalDateTime.now())
//                        .build();
//
//        ProductUnit unit1 =
//                ProductUnit
//                        .builder()
//                        .name("adad")
//                        .build();
//
//        ProductUnit unit2 =
//                ProductUnit
//                        .builder()
//                        .name("Cm")
//                        .build();
//
//        ProductUnitService.getService().save(unit1);
//        ProductUnitService.getService().save(unit2);
//        System.out.println(ProductUnitService.getService().findAll());
//
//        ProductGroup root =
//                ProductGroup
//                        .builder()
//                        .name("mobile")
//                        .parentGroup(null)
//                        .status(true)
//                        .build();
//
//        ProductGroup child1 =
//                ProductGroup
//                        .builder()
//                        .name("samsung")
//                        .parentGroup(root)
//                        .status(true)
//                        .build();
//
//        ProductGroup child2 =
//                ProductGroup
//                        .builder()
//                        .name("apple")
//                        .parentGroup(root)
//                        .status(true)
//                        .build();
//
//        ProductGroup child3 =
//                ProductGroup
//                        .builder()
//                        .name("5S")
//                        .parentGroup(child2)
//                        .status(true)
//                        .build();
//
//        ProductGroupService.getService().save(root);
//        ProductGroupService.getService().save(child1);
//        ProductGroupService.getService().save(child2);
//        System.out.println(ProductGroupService.getService().save(child3));

        Product product =
                Product
                        .builder()
                        .name("mobile")
                        .barcode("1234")
                        .unit(null)
                        .productGroup(null)
                        .build();

//        product.addAttachment(attachment1);
//        product.addAttachment(attachment2);
        ProductService productService =null;

        System.out.println(productService.save(product));
    }
}
