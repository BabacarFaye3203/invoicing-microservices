package com.babacar.app.services;

import com.babacar.app.dto.requests.CreateCurrencyRequest;
import com.babacar.app.dto.responses.CurrencyResponse;
import com.babacar.app.entities.Currency;
import com.babacar.app.mappers.CurrencyMapper;
import com.babacar.app.repositories.CurrencyRepository;
import com.babacar.app.validators.CurrencyValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final CurrencyRepository currencyRepository;
    private final CurrencyMapper currencyMapper;
    private final CurrencyValidator currencyValidator;

    public CurrencyResponse create(CreateCurrencyRequest request){

        Currency validCurrency=currencyValidator.validate(request.name());
        Currency currency =new Currency();
        String generatedUuid= UUID.randomUUID().toString();

        currency.setUuid(generatedUuid);
        currency.setName(currency.getName());
        currency.setDescription(request.description());
        currency.setActive(request.isActive());
        currencyRepository.save(currency);

        CurrencyResponse response= currencyMapper.toCurrencyResponse(currency);

        return  response;

    }

    public CurrencyResponse getCurrency(String uuid){

        Optional<Currency> currency=currencyRepository.findByUuid(uuid);

        if(currency.isPresent()){
            CurrencyResponse response= currencyMapper.toCurrencyResponse(currency.get());
            return response;
        }

        return null;
    }

    public void markAsActive(String uuid){
        Optional<Currency> currency=currencyRepository.findByUuid(uuid);

        if (currency.isPresent()){
            currency.get().setActive(true);
        }
    }
}
