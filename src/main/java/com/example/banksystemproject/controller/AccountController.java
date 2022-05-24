package com.example.banksystemproject.controller;

import com.example.banksystemproject.domain.entity.Account;
import com.example.banksystemproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {


    private final AccountService accountService;

    @Autowired
    public AccountController(@Qualifier(value = "account_service")AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<Account> save(@PathVariable("id") Long clientId) {
        Account account = accountService.save(clientId);
        if (account == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.ok(account);
    }






}
