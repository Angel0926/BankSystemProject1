package com.example.banksystemproject.service;

import com.example.banksystemproject.domain.entity.Account;
import com.example.banksystemproject.domain.entity.Client;
import com.example.banksystemproject.dto.AccountDto;


public interface AccountService {

    Account save(Long clientId) ;

    Account update(Long id, AccountDto accountDto);

    void delete(Long id);

    void transferToCard(double amount,Long fromAccountId,Long toAccountId);

    void transferToAccount(double amount, Client fromClient, String IBAN);
}
