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
        deliveryService.deliverySave(delivery1);
        deliveryService.deliverySave(delivery2);
        deliveryService.deliverySave(delivery3);
        deliveryService.deliverySave(delivery4);
        System.out.println(deliveryService.deliveryFindAll());
        System.out.println(deliveryService.deliveryFindById(1L));
        System.out.println(deliveryService.deliveryFindByDeliveryStatus(DeliveryStatus.SENDING));

      //  System.out.println(deliveryService.deliveryFindByNameAndFamily("ali", "alipour"));
        System.out.println(deliveryService.deliveryFindByOrderId("asdfghjkl"));
        System.out.println(deliveryService.deliveryFindByReceiverName("Mohammad"));
        System.out.println(deliveryService.deliveryFindAll());
        System.out.println(deliveryService.deliveryFindAll());
        deliveryService.deliveryRemove(2L);
        deliveryService.deliveryRemove(1L);
        System.out.println(deliveryService.deliveryFindAll());
    }
}
