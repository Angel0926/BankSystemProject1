package com.example.banksystemproject.controller;

import com.example.banksystemproject.exception.ApiRequestException;
import com.example.banksystemproject.dto.request.AccountRequestDto;
import com.example.banksystemproject.dto.responce.AccountResponseDto;
import com.example.banksystemproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestController
@RequestMapping("/account")
public class AccountController {


    private final AccountService accountService;


    @Autowired
    public AccountController(@Qualifier(value = "account_service")AccountService accountService) {
        this.accountService = accountService;

    }

    @PostMapping("/{id}")
    public ResponseEntity<AccountResponseDto> save(@RequestBody AccountRequestDto accountRequestDto,
                                                   @PathVariable("id") Long clientId) {

        AccountResponseDto accountResponseDto = null;
        try {
            accountResponseDto = accountService.save(clientId,accountRequestDto);
        } catch (UserPrincipalNotFoundException e) {
            String message = e.getName();
            throw new ApiRequestException(message);
        }
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


    @PutMapping("/{id}")
    public ResponseEntity<AccountResponseDto> update(@RequestBody AccountRequestDto accountRequestDto,
                                                     @PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(accountService.update(id, accountRequestDto));
        } catch (UserPrincipalNotFoundException e) {
            String message = e.getName();
            throw new ApiRequestException(message);}}



    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {

        try {
            accountService.delete(id);
            return ResponseEntity.ok().build();

        } catch (UserPrincipalNotFoundException e) {
            String message = e.getName();
            throw new ApiRequestException(message);
        }
    }


    }









