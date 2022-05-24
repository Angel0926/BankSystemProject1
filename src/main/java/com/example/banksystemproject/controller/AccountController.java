package com.example.banksystemproject.controller;

import com.example.banksystemproject.dto.responce.AccountResponseDto;
import com.example.banksystemproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {


    private final AccountService accountService;

    @Autowired
    public AccountController(@Qualifier(value = "account_service")AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<AccountResponseDto> save(@PathVariable("id") Long clientId) {
        AccountResponseDto accountResponseDto = accountService.save(clientId);
        if (accountResponseDto == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.ok(accountResponseDto);
    }

    @PostMapping("/transfer")

public ResponseEntity<?> transfer(@RequestParam double amount,
                                  @RequestParam(required = false)  Long fromAccountId ,
                                  @RequestParam Long toAccountId){
        if(fromAccountId == null){
            accountService.transferToAccount(amount,toAccountId);
            return ResponseEntity.ok().build();

        }
        accountService.transferToCard(amount,fromAccountId,toAccountId);
        return ResponseEntity.ok().build();
    }




}
