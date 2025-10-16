package com.babacar.app.repositories;

import com.babacar.app.entities.InvoiceProducts;
import com.babacar.app.entities.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoices, Long> {


    Optional<Invoices> findByUuid(String uuid);

    boolean existsByNumber(String invoiceNumber);

}
