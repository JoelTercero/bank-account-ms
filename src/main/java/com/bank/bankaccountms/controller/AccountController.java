package com.bank.bankaccountms.controller;

import com.bank.bankaccountms.dto.AccountRequest;
import com.bank.bankaccountms.dto.AccountResponse;
import com.bank.bankaccountms.service.AccountService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(
        name = "Accounts",
        description = "REST endpoints for creating, retrieving and managing bank accounts."
)
@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @Operation(
            summary = "Create account",
            description = "Creates a new bank account with ACTIVE status."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Account created successfully"),
            @ApiResponse(responseCode = "400", description = "Validation error")
    })
    @PostMapping
    public ResponseEntity<AccountResponse> create(
            @Valid @RequestBody AccountRequest request){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.create(request));

    }

    @Operation(
            summary = "Get all accounts",
            description = "Returns all registered bank accounts."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Accounts retrieved successfully")
    })
    @GetMapping
    public ResponseEntity<List<AccountResponse>> findAll() {

        return ResponseEntity.ok(service.findAll());
    }

    @Operation(
            summary = "Get account by ID",
            description = "Returns a bank account by its identifier."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account found"),
            @ApiResponse(responseCode = "404", description = "Account not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.findById(id));
    }

    @Operation(
            summary = "Block account",
            description = "Blocks a bank account by changing its status to BLOCKED."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account blocked successfully"),
            @ApiResponse(responseCode = "404", description = "Account not found")
    })
    @PutMapping("/{id}/block")
    public ResponseEntity<AccountResponse> blockAccount(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.blockAccount(id));
    }

}
