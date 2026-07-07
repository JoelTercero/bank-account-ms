package com.bank.bankaccountms.controller;

import com.bank.bankaccountms.dto.AccountRequest;
import com.bank.bankaccountms.dto.AccountResponse;
import com.bank.bankaccountms.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @PostMapping
    public ResponseEntity<AccountResponse> create(
            @Valid @RequestBody AccountRequest request){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.create(request));

    }

    @GetMapping
    public ResponseEntity<List<AccountResponse>> findAll() {

        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}/block")
    public ResponseEntity<AccountResponse> blockAccount(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.blockAccount(id));
    }

}
