package org.kaczucha.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AccountRequest {
    private double balance;
    private String currency;
    private Long userId;
}
