package com.store.onlinestore.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "invoiceEntity")
@Table(name = "invoice_tbl")

public class Invoice extends Base {


    @Id
    @SequenceGenerator(name = "invoiceSeq", sequenceName = "invoice_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoiceSeq")
    @Column(name = "id")
    private Long id;

    @Column(name = "serial", length = 10)
//    @Pattern(regexp = "^[A-Z]{1}-[\\d]{5}$", message = "Invalid Serial")
    private String serial;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "date_time")
    private LocalDateTime localDateTime;

    @Column(name = "amount")
    private int amount;

    @Column(name = "invoice_comment")
    private String invoiceComment;

    @OneToMany(mappedBy = "invoice", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinColumn(name= "invoiceItem_id")
    private List<InvoiceItem> invoiceItemList;

    @Column(name = "discount")
    private int discount;

    @Column(name = "pure_amount")
    private int pureAmount;

//    @OneToOne
//    @JoinColumn(name = "PaymentTransaction_id")
//    private PaymentTransaction payement;

    public int getAmount() {
        amount = 0;
        invoiceItemList.forEach(
                item -> amount += item.getCount() * item.getPrice()
        );
        return amount;
    }

    public int getPureAmount(){
        pureAmount = getAmount() - discount;
        return pureAmount;
    }

    public void addItem(InvoiceItem item){
        if(invoiceItemList == null){
            invoiceItemList = new ArrayList<>();
        }
        invoiceItemList.add(item);
    }
}

