package com.store.onlinestore.model.entity;

import com.store.onlinestore.model.entity.enums.DeliveryMethod;
import com.store.onlinestore.model.entity.enums.DeliveryStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@NamedQueries(
        {
                @NamedQuery(name = "Delivery.FindByOrderId", query = "SELECT oo FROM deliveryEntity oo WHERE oo.orderId=:orderId")
                , @NamedQuery(name = "Delivery.FindByName", query = "SELECT oo FROM deliveryEntity oo WHERE oo.invoice.customer.name LIKE :customerName")
                , @NamedQuery(name = "Delivery.FindByFamily", query = "SELECT oo FROM deliveryEntity oo WHERE oo.invoice.customer.family LIKE :customerFamily")
                , @NamedQuery(name = "Delivery.FindByNameAndFamily", query = "SELECT oo FROM deliveryEntity oo WHERE oo.invoice.customer.name LIKE :customerName AND oo.invoice.customer.family LIKE : customerFamily")
                , @NamedQuery(name = "Delivery.FindByReceiverName", query = "SELECT oo FROM deliveryEntity oo WHERE oo.receiverName=:receiverName")
                , @NamedQuery(name = "Delivery.FindByDeliveryStatus", query = "SELECT oo FROM deliveryEntity oo WHERE oo.deliveryStatus=:deliveryStatus")
                ,@NamedQuery(name = "Delivery.FindByDeliveryMethod",query = "SELECT oo FROM deliveryEntity oo WHERE  oo.deliveryMethod =:deliveryMethod")
        }
)

@Entity(name = "deliveryEntity")
@Table(name = "delivery_tbl")
public class Delivery extends Base {
    @Id
    @SequenceGenerator(name = "deliverySeq", sequenceName = "delivery", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Long id;

    @OneToOne
    private Invoice invoice;

    @Column(name = "orderId", length = 9)
//    @Pattern(regexp = "^[a-zA-Z]{9}$",message = "Invalid Order Id")
    private String orderId;

    @Column(name = "receiver_name", length = 30)
//    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$",message = "Invalid Receiver Name")
    private String receiverName;

    @Column(name = "delivery_method", length = 15)
    @Enumerated(EnumType.ORDINAL)
    private DeliveryMethod deliveryMethod;

    @Column(name = "status", length = 15)
    @Enumerated(EnumType.ORDINAL)
    private DeliveryStatus deliveryStatus;

    @Column(name = "sending_date_time")
    private LocalDateTime sendingDateTime;

    @Column(name = "delivered_date_time")
    private LocalDateTime deliveredDateTime;

    @Column(name = "returned_date_time")
    private LocalDateTime returnedDateTime;

    // todo : attachment signature
//    @Column(name = "signature_link")
//    private String signature;


    @Column(name = "description")
//    @Pattern(regexp = "^[a-zA-Z0-9&@$_\\-\\s]{5,255}$",message = "Invalid description")
    private String description;

}
