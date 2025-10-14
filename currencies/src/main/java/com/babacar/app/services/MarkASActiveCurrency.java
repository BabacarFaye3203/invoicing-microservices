package com.babacar.app.services;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name="currency API")
@RequiredArgsConstructor
@RequestMapping("/api/v1/currencies")
public class MarkASActiveCurrency {
    private final CurrencyService currencyService;

    @PatchMapping("/mark-as-active")
    @Operation(summary = "mark a currency as active")
    public void markAsActive(String uuid){
        currencyService.markAsActive(uuid);
    }

}
