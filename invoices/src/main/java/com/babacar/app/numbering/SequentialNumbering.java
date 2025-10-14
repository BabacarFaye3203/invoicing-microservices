package com.babacar.app.numbering;

import com.babacar.app.repositories.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SequentialNumbering {
    private final InvoiceRepository invoiceRepository;

    public String getValidDocumentNumber( String lang,Integer number) throws BadRequestException {
        var i = 0;
        var invoiceNumber = NumberingFormatter.getFormattedNumber(lang, number);
        while (invoiceRepository.existsByNumber(invoiceNumber)) {
            invoiceNumber = NumberingFormatter.getFormattedNumber(lang, number + i);
            i += 1;
            return invoiceNumber;
        }
        return invoiceNumber;
    }

}
