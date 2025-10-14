package com.babacar.app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "invoice_products",schema = "public")
public class InvoiceProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "product_uuid")
    private String product;

    private String designation;

    @Column(name = "unit_price")
    private double unitPrice;

    private double quantity;

    private double discount;

    private double taxe;

    @Column(name = "total_price")
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    @JsonBackReference
    private Invoices invoice;

    @Column(name = "discount_type")
    private String discountType;

    @ManyToOne(optional = false)
    private Invoices invoices;

}
