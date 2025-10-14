package com.babacar.app.services;

import com.babacar.app.dto.responses.CurrencyResponse;
import com.babacar.app.entities.Currency;
import com.babacar.app.mappers.CurrencyMapper;
import com.babacar.app.repositories.CurrencyRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@Tag(name = "currency API")
@RequiredArgsConstructor
@RequestMapping("/api/v1/currencies")
public class GetCurrencyService {

    private final CurrencyService currencyService;
    private final CurrencyRepository currencyRepository;
    private final CurrencyMapper currencyMapper;

    @GetMapping("/{uuid}")
    @Operation(summary = "get a currency by uuid")
    public CurrencyResponse getCurrency(
            @PathVariable(name = "uuid") String uuid){

        return  currencyService.getCurrency(uuid);
    }
}
