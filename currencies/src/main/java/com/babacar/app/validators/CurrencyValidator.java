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

    public void validate(String uuid){
        if (uuid.contains(CurrencyConstants.VALID_CURRENCY)){
            throw  new RuntimeException("invalid currency");
        }

    }
}
