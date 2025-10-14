package com.babacar.app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="invoice_payments",schema = "public")
@Getter
@Setter
public class InvoicePayments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id")
    @JsonBackReference
    private Invoices invoice;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Column(name="payment_method")
    private String paymentMethods;

    @Column(name = "amount")
    private Double amount;

    @Override
    public boolean equals(Object obj) {
        if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        InvoicePayments payment = (InvoicePayments) obj;
        return Objects.equals(this.id, payment.id);
    }

    @Override
    public int hashCode(){
        return 1;
    }
}
