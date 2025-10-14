package com.babacar.app.numbering;

import com.babacar.app.entities.Invoices;
import org.apache.coyote.BadRequestException;

public interface DocumentNumbering {
    void manageNumbering(Invoices document, Integer manualNumber) throws BadRequestException;
}
