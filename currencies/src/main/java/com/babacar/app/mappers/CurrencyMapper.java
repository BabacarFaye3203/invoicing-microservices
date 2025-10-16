package com.babacar.app.mappers;

import com.babacar.app.dto.responses.CurrencyResponse;
import com.babacar.app.entities.Currency;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CurrencyMapper {

    @Mapping(source = "uuid", target = "uuid")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "active", target = "isActive")
    CurrencyResponse toCurrencyResponse(Currency currency);
}
