package com.babacar.app.entities;

import com.babacar.app.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "invoice_pricing",schema = "public")
public class InvoicePricing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "price")
    private Double price;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "discount_type")
    private String discountType;

    @Column(name = "advance_payment")
    private Double advancePayment;


    @Column(name = "payment_method_id")
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
}
