package org.kaczucha.controller;

import lombok.RequiredArgsConstructor;
import org.kaczucha.controller.dto.CurrencyResponse;
import org.kaczucha.service.CurrencyService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Currency;

@RestController
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyService service;
    @GetMapping(path = "api/currency")
    public ResponseEntity<CurrencyResponse> getCurrencyRates(){
        final CurrencyResponse currencyRates = service.getCurrencyRates();
        return new ResponseEntity<>(currencyRates, HttpStatus.ACCEPTED);
    }

}
