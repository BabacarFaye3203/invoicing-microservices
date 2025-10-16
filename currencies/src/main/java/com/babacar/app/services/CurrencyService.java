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

        this.currencyValidator.validate(request.name());
        Currency currency =new Currency();
        String generatedUuid= UUID.randomUUID().toString();
        currency.setUuid(generatedUuid);
        currency.setName(request.name());
        currency.setDescription(request.description());
        currency.setActive(request.isActive());
        currencyRepository.save(currency);

        return  currencyMapper.toCurrencyResponse(currency);

    }


    public void markAsActive(String uuid){
       Currency currency=currencyRepository.findByUuid(uuid).orElseThrow(
                ()->new NoSuchElementException("currency not found")
        );
        currency.setActive(true);

    }
}
