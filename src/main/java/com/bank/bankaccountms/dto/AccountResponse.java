package com.bank.bankaccountms.dto;

import com.bank.bankaccountms.enums.Status;

import java.math.BigDecimal;

public record AccountResponse(

    Long id,
    String accountNumber,
    String customerName,
    BigDecimal balance,
    Status status
) {
}
