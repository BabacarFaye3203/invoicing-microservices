package com.babacar.app.services;

import com.babacar.app.entities.Currency;
import com.babacar.app.repositories.CurrencyRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;
@Service
@RequiredArgsConstructor
public class MarkASActiveCurrency{
    private final CurrencyRepository currencyRepository;

    public void toggleActive(String uuid){
       Currency currency= currencyRepository.findByUuid(uuid).orElseThrow(
               ()->new NoSuchElementException("currency not found "));

       if (currency.isActive()==true){
           currency.setActive(false);
       }else{
           currency.setActive(true);
       }

       currency.setActive(true);
    }

}
