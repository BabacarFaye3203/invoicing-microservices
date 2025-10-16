package com.babacar.app.controllers;

import com.babacar.app.dto.requests.CreateCurrencyRequest;
import com.babacar.app.dto.responses.CurrencyResponse;
import com.babacar.app.services.CurrencyService;
import com.babacar.app.services.GetCurrencyService;
import com.babacar.app.services.MarkASActiveCurrency;
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
    private final GetCurrencyService getCurrencyService;
    private final MarkASActiveCurrency markASActiveCurrency;

    @PostMapping
    @Operation(summary = "creation of a currency")
    public CurrencyResponse create(
            @RequestBody CreateCurrencyRequest request){

        return currencyService.create(request);

    }

    @GetMapping("/{uuid}")
    @Operation(summary = "get a currency by uuid")
    public CurrencyResponse getCurrency(
            @PathVariable(name = "uuid") String uuid){

        return  getCurrencyService.getCurrency(uuid);
    }

    @PatchMapping("/mark-as-active/{uuid}")
    public void mark(
            @PathVariable("uuid") String uuid){
        markASActiveCurrency.toggleActive(uuid);
    }
}
