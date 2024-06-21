package com.store.onlinestore.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@Entity(name = "invoiceEntity")
@Table(name = "invoice_tbl")
@NamedQueries({
        @NamedQuery(name = "Invoice.FindByCustomer", query = "select i from invoiceEntity i where i.customer.id = customer.id"),
        @NamedQuery(name = "Invoice.FindBySerial", query = "select i from invoiceEntity i where i.serial like :serial"),
        @NamedQuery(name = "Invoice.FindByDate", query = "select  i from invoiceEntity i where  i.localDateTime = :localDateTime"),
        @NamedQuery(name = "Invoice.FindByRangeDate", query = "select  i from invoiceEntity i where  i.localDateTime between :localDateTime and :localDateTime")
})

public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "serial", length = 15)
    private String serial;

    @ManyToOne
    private Person customer;

    @Column(name = "date_time")
    private LocalDateTime localDateTime;

    @Column(name = "amount")
    private int amount;


    @OneToMany
    private List<InvoiceItem> invoiceItemList;


    public int getAmount() {
        amount = 0;
        invoiceItemList.forEach(
                item -> amount += item.getCount() * item.getPrice()
        );
        return amount;
    }

    //TODO Use payment Clas or use variable
//    @Column(name = "discount")
//    private int discount;
//
//    @Column(name = "pure_amount")
//    private int pureAmount;

    @OneToOne
    private PaymentTransaction payement;


}

