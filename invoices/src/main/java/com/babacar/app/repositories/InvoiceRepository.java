package com.babacar.app.repositories;

import com.babacar.app.entities.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoices, Long> {

    Invoices findByUuid(String uuid);

    boolean existsByNumber(String invoiceNumber);
}
