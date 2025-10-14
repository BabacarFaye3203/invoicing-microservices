package com.babacar.app.mappers;

import com.babacar.app.dto.responses.CurrencyResponse;
import com.babacar.app.entities.Currency;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CurrencyMapper {

    CurrencyResponse toCurrencyResponse(Currency currency);
}
