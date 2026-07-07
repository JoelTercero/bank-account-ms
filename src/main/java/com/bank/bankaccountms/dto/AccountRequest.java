package com.bank.bankaccountms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

public record AccountRequest(

        @Schema(example = "1234567890")
        @NotBlank(message = "Account number is required")
        String accountNumber,

        @Schema(example = "Joel Tercero")
        @NotBlank(message = "Customer name is required")
        String customerName,

        @Schema(example = "1500.50")
        @NotNull(message = "Balance is required")
        @PositiveOrZero(message = "Balance must be greater than or equal to zero")
        BigDecimal balance

) {
}
