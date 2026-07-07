package com.bank.bankaccountms.dto;

import com.bank.bankaccountms.enums.Status;
import java.math.BigDecimal;
import io.swagger.v3.oas.annotations.media.Schema;

public record AccountResponse(

    @Schema(example = "1")
    Long id,

    @Schema(example = "1234567890")
    String accountNumber,

    @Schema(example = "Joel Tercero")
    String customerName,

    @Schema(example = "1500.50")
    BigDecimal balance,

    @Schema(example = "ACTIVE")
    Status status
) {
}
