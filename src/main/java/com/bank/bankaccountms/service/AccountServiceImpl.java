package com.bank.bankaccountms.service;

import com.bank.bankaccountms.dto.AccountRequest;
import com.bank.bankaccountms.dto.AccountResponse;
import com.bank.bankaccountms.entity.Account;
import com.bank.bankaccountms.enums.Status;
import com.bank.bankaccountms.exception.ResourceNotFoundException;
import com.bank.bankaccountms.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public AccountResponse create(AccountRequest request) {
        Account account = toEntity(request);
        account.setStatus(Status.ACTIVE);

        return toResponse(accountRepository.save(account));
    }

    @Override
    public List<AccountResponse> findAll() {
        return accountRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public AccountResponse findById(Long id) {
        return toResponse(getAccountById(id));
    }

    @Override
    public AccountResponse blockAccount(Long id) {
        Account account = getAccountById(id);
        account.setStatus(Status.BLOCKED);

        return toResponse(accountRepository.save(account));
    }

    private Account toEntity(AccountRequest request) {

        return Account.builder()
                .accountNumber(request.accountNumber())
                .customerName(request.customerName())
                .balance(request.balance())
                .build();
    }

    private AccountResponse toResponse(Account account) {

        return new AccountResponse(
                account.getId(),
                account.getAccountNumber(),
                account.getCustomerName(),
                account.getBalance(),
                account.getStatus()
        );

    }

    private Account getAccountById(Long id) {

        return accountRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Account not found"));

    }
}