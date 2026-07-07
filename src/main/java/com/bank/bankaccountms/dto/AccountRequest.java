package com.bank.bankaccountms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record AccountRequest(

        @NotBlank(message = "Account number is required")
        String accountNumber,

        @NotBlank(message = "Customer name is required")
        String customerName,

        @NotNull(message = "Balance is required")
        @PositiveOrZero(message = "Balance must be greater than or equal to zero")
        BigDecimal balance

) {
}
