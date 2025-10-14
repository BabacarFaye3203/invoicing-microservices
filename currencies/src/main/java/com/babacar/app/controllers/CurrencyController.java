package com.babacar.app.controllers;

import com.babacar.app.dto.requests.CreateCurrencyRequest;
import com.babacar.app.dto.responses.CurrencyResponse;
import com.babacar.app.services.CurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "currency API")
@RequestMapping(path = "/api/v1/currencies")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "creation of a currency")
    public CurrencyResponse create(
            @RequestBody CreateCurrencyRequest request){

        return currencyService.create(request);

    }

}
