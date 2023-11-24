package org.kaczucha.service;

import org.kaczucha.controller.dto.CurrencyResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class CurrencyService {
    public CurrencyResponse getCurrencyRates() {
        final RestTemplate restTemplate = new RestTemplate();
        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("base","USD");
        final ResponseEntity<CurrencyResponse> response = restTemplate
                .getForEntity("https://api.exhcnageratesapi.io/latest",
                        CurrencyResponse.class
                );
        return response.getBody();
    }
}
