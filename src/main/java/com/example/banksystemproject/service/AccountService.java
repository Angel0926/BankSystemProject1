package com.example.banksystemproject.service;

import com.example.banksystemproject.domain.entity.Account;
import com.example.banksystemproject.domain.entity.Client;
import com.example.banksystemproject.dto.request.CreateAccountDto;


public interface AccountService {

    Account save(CreateAccountDto accountDto);

    Account update(Long id, CreateAccountDto accountDto);

    void delete(Long id);

    void transferToCard(double amount,Long fromAccountId,Long toAccountId);

    void transferToAccount(double amount, Client fromClient, String IBAN);
}
