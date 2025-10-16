package com.babacar.app.mappers;

import com.babacar.app.dto.responses.CreateInvoiceResponse;
import com.babacar.app.entities.Invoices;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    CreateInvoiceResponse toCreateInvoiceResponse(Invoices invoices);
}
