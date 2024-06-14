import com.store.onlinestore.model.entity.Person;
import com.store.onlinestore.model.service.PersonService;

public class PersonTest {
    public static void main(String[] args) throws Exception {
        Person person1 =
                Person
                        .builder()
                        .name("ahmad")
                        .family("messbah")
                        .phoneNumber("123456")
                        .email("a@a.com")
                        .image("/img/0001.jpg")
                        .build();

        Person person2 =
                Person
                        .builder()
                        .name("ahmad2")
                        .family("messbah2")
                        .phoneNumber("1234562")
                        .email("a2@a.com")
                        .image("/img/0002.jpg")
                        .build();

        System.out.println(PersonService.getService().save(person1));
        System.out.println(PersonService.getService().save(person2));

        System.out.println(PersonService.getService().findAll());

        System.out.println(PersonService.getService().findByNameAndFamily("a","m"));
    }
}
