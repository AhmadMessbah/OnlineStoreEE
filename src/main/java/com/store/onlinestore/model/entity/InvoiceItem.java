package com.store.onlinestore.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name="invoiceItemEntity")
@Table(name="invoice_item_tbl")
public class InvoiceItem extends Base{
    @Id
    @SequenceGenerator(name = "invoiceItemSeq", sequenceName = "invoice_item_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoiceItemSeq")
    private Long id;

    @OneToOne
    private Product product;

    @Column(name = "count")
    private int count;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
}
