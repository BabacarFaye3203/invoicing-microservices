package com.babacar.app.mappers;

import com.babacar.app.dto.responses.PaymentResponse;
import com.babacar.app.entities.Payments;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentResponse toPaymentResponse(Payments payments);
}
