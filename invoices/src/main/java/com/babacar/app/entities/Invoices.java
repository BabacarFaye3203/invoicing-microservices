package com.babacar.app.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "invoices",schema = "public")
public class Invoices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "language")
    private String language;

    @Column(name = "number")
    private String number;

    @Column(name = "status")
    private String status;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;

    @Column(name = "individual_customer")
    private String individualCustomer;

    @OneToMany(
            mappedBy = "invoice",
            cascade = CascadeType.ALL,
            orphanRemoval = false,
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<InvoiceProducts> invoiceProducts= new ArrayList<>();

    private String Payment;

    @Column(name = "currency")
    String currency;

}
