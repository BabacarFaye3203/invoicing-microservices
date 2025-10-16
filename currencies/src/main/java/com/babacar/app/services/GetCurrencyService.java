package com.babacar.app.services;

import com.babacar.app.dto.responses.CurrencyResponse;
import com.babacar.app.entities.Currency;
import com.babacar.app.mappers.CurrencyMapper;
import com.babacar.app.repositories.CurrencyRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetCurrencyService {

    private final CurrencyRepository currencyRepository;
    private final  CurrencyMapper currencyMapper;

    public CurrencyResponse getCurrency(String uuid){

        Currency currency=currencyRepository.findByUuid(uuid).orElseThrow(()->
                new NoSuchElementException("currency not found"));
        CurrencyResponse response= currencyMapper.toCurrencyResponse(currency);
        return response;

    }


}
