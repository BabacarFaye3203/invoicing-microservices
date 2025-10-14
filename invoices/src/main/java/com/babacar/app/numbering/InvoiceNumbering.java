package com.babacar.app.numbering;

import com.babacar.app.constants.InvoiceStatusConstants;
import com.babacar.app.entities.Invoices;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceNumbering implements DocumentNumbering{
    private final SequentialNumbering sequentialNumbering;


    public void manageNumbering(Invoices invoice, Integer manualNumber) throws BadRequestException {

        if (InvoiceStatusConstants.DRAFT.equals(invoice.getStatus())) {
            invoice.setNumber(null);
            return;
        }
        String validNumber;
        if (!InvoiceStatusConstants.DRAFT.equals(invoice.getStatus())) {
            validNumber = sequentialNumbering.getValidDocumentNumber(invoice.getLanguage(),manualNumber);
            invoice.setNumber(validNumber);
        }
    }
}
