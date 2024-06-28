import com.store.onlinestore.model.entity.Delivery;
import com.store.onlinestore.model.entity.enums.DeliveryStatus;
import com.store.onlinestore.model.service.DeliveryService;

public class DeliveryTest {
    public static void main(String[] args) throws Exception {
        DeliveryService deliveryService = DeliveryService.getDeliveryService();
        Delivery delivery1 = Delivery.builder()
                .orderId("abcdhdsfshhadssd")
                .receiverName("Mehrdad")
                .description("hdsk hkfsdl s sajoi#$%@%$#@$*/-/+")
                .build();
        Delivery delivery2 = Delivery.builder()
                .orderId("abcdhdsfshha n")
                .receiverName("_Abbas")
                .description("hdsk hkfsdl s sajoi#$%@%$#@$*/-/+")
                .build();
        Delivery delivery3 = Delivery.builder()
                .orderId("asdfghjkl")
                .receiverName("Behroz")
                .description("hdsk hkfsdl s sajoi#$%@%$#@$*/-/+")
                .build();
        Delivery delivery4 = Delivery.builder()
                .orderId("abc dhshha")
                .receiverName("Mohammad")
                .description("hdsk hkfsdl s sajoi#$%@%$#@$*/-/+")
                .build();
        deliveryService.save(delivery1);
        deliveryService.save(delivery2);
        deliveryService.save(delivery3);
        deliveryService.save(delivery4);
        System.out.println(deliveryService.findAll());
        System.out.println(deliveryService.findById(1L));
        System.out.println(deliveryService.findByDeliveryStatus(DeliveryStatus.SENDING));
      //  System.out.println(deliveryService.deliveryFindByNameAndFamily("ali", "alipour"));
        System.out.println(deliveryService.findByOrderId("asdfghjkl"));
        System.out.println(deliveryService.findByReceiverName("Mohammad"));
        System.out.println(deliveryService.findAll());
        System.out.println(deliveryService.findAll());
        deliveryService.remove(2L);
        deliveryService.remove(1L);
        System.out.println(deliveryService.findAll());
    }
}
