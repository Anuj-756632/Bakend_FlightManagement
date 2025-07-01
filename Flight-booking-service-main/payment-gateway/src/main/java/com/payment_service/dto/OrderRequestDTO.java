package com.payment_service.dto;

import lombok.Data;

@Data
public class OrderRequestDTO {
    private int amount; // In paise
    private String currency;
    private String receipt;
}