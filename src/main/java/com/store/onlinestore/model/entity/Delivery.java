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

import java.io.File;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@NamedQueries(
        {
                @NamedQuery(name = "Delivery.FindByOrderId", query = "SELECT O FROM deliveryEntity O WHERE O.orderId=orderId")
                , @NamedQuery(name = "Delivery.FindByName", query = "SELECT O FROM deliveryEntity O WHERE O.customerName LIKE :customerName")
                , @NamedQuery(name = "Delivery.FindByFamily", query = "SELECT O FROM deliveryEntity O WHERE O.customerFamily LIKE :customerFamily")
                , @NamedQuery(name = "Delivery.FindByNameAndFamily", query = "SELECT O FROM deliveryEntity O WHERE O.customerName LIKE :customerName AND O.customerFamily LIKE : customerFamily")
                , @NamedQuery(name = "Delivery.FindByReceiverName", query = "SELECT O FROM deliveryEntity O WHERE O.receiverName=receiverName")
                , @NamedQuery(name = "Delivery.FindByDeliveryStatus", query = "SELECT O FROM deliveryEntity O WHERE O.deliveryStatus=deliveryStatus")
        }
)

@Entity(name = "deliveryEntity")
@Table(name = "delivery_tbl")
public class Delivery {
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
    @Column(name = "customer_name", length = 30)
//    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$",message = "Invalid Customer Name")
    private final String customerName = invoice.getCustomer().getName();
    @Column(name = "customer_family", length = 30)
//    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$",message = "Invalid Customer Family")
    private final String customerFamily = invoice.getCustomer().getFamily();
    //    todo: Dar Class Customer Bayad Bakhsh address Tarif Beshe
//    private final String Address=invoice.getCustomer().getAddress().getFullAddress();
//    private final String postalCode = invoice.getCustomer().getAddress().getPostalCode();
    @Column(name = "receiver_name", length = 30)
//    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$",message = "Invalid Receiver Name")
    private String receiverName;
    @Column(name = "delivery_method", length = 15)
    @Enumerated(EnumType.STRING)
    private DeliveryMethod deliveryMethod;
    @Column(name = "status", length = 15)
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;
    @Column(name = "sending_date_time")
    private LocalDateTime sendingDateTime;
    @Column(name = "delivered_date_time")
    private LocalDateTime deliveredDateTime;
    @Column(name = "returned_date_time")
    private LocalDateTime returnedDateTime;
    @Column(name = "signiture_link")
    private String signature;
    @Column(name = "description")
//    @Pattern(regexp = "^[a-zA-Z0-9&@$_\\-\\s]{5,255}$",message = "Invalid description")
    private String description;

}
