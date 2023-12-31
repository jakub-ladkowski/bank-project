package org.kaczucha.controller.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Map;

@Data
public class CurrencyResponse {
    private String base;
    private LocalDate date;
    private Map<String, Double> rates;
}
