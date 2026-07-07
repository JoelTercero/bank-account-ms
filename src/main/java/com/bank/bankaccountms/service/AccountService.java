package com.bank.bankaccountms.service;

import com.bank.bankaccountms.dto.AccountRequest;
import com.bank.bankaccountms.dto.AccountResponse;

import java.util.List;

public interface AccountService {

    AccountResponse create(AccountRequest request);

    List<AccountResponse> findAll();

    AccountResponse findById(Long id);

    AccountResponse blockAccount(Long id);

}
