import com.store.onlinestore.controller.validation.BeanValidator;
import com.store.onlinestore.model.entity.Supplier;
import com.store.onlinestore.model.service.SupplierService;

public class SupplierTest {
    public static void main(String[] args) throws Exception {

        Supplier supplier1 = Supplier.builder()
                .name("ali")
                .family("alipoor")
                .mobilePhone("09177772424")
                .nationalCode("3490006200")
                .email("alipoor@gmail.com")
                .companyName("ramak")
                .build();

        Supplier supplier2 = Supplier.builder()
                .name("saeed")
                .family("saeedi")
                .mobilePhone("09178882424")
                .nationalCode("1110006200")
                .email("saeedi@gmail.com")
                .companyName("pegah")
                .build();

//        BeanValidator<Supplier> supplierValidator = new BeanValidator<>();
//        System.out.println(supplierValidator.validate(supplier1));
//        System.out.println(supplierValidator.validate(supplier2));
//
//        System.out.println(SupplierService.getService().save(supplier1));
//        System.out.println(SupplierService.getService().save(supplier2));
//
//        System.out.println(SupplierService.getService().findAll());
//        System.out.println(SupplierService.getService().findByNameAndFamily("ali", "alipoor"));
//        System.out.println(SupplierService.getService().findByMobilePhone("09178882424"));
//        System.out.println(SupplierService.getService().findByNationalCode("1110006200"));
//        System.out.println(SupplierService.getService().findByCompany("ramak"));
    }
}
