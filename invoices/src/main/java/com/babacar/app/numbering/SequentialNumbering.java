package com.babacar.app.numbering;

import com.babacar.app.repositories.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SequentialNumbering {

    private final InvoiceRepository invoiceRepository;

    public String getValidDocumentNumber(String lang, Integer number) throws BadRequestException {
        int i = 0;
        String invoiceNumber = NumberingFormatter.getFormattedNumber(lang, number);
        while (invoiceRepository.existsByNumber(invoiceNumber)) {
            i += 1;
            invoiceNumber = NumberingFormatter.getFormattedNumber(lang, number + i);
        }
        return invoiceNumber;
    }
}
