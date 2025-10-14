package com.babacar.app.validators;

import com.babacar.app.constants.CurrencyConstants;
import com.babacar.app.entities.Currency;
import com.babacar.app.repositories.CurrencyRepository;
import com.babacar.app.services.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyValidator {
    private final CurrencyRepository currencyRepository;

    public Currency validate(String uuid){

        Currency currency=currencyRepository.findByUuid(uuid).get();
        if (currency.getName().contains(CurrencyConstants.VALID_CURRENCY)){
            return currency;
        }else {
            throw  new RuntimeException("invalid currency");
        }

    }
}
