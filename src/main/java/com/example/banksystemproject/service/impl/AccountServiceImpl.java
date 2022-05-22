package com.example.banksystemproject.service.impl;

import com.example.banksystemproject.domain.entity.Account;
import com.example.banksystemproject.domain.entity.Client;
import com.example.banksystemproject.dto.request.CreateAccountDto;
import com.example.banksystemproject.repository.AccountRepo;
import com.example.banksystemproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("account_service")
public class AccountServiceImpl implements AccountService {

    private final AccountRepo accountRepo;

    @Autowired
    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public Account save(CreateAccountDto accountDto) {
        return null;
    }

    @Override
    public Account update(Long id, CreateAccountDto accountDto) {
        return null;
    }

    @Override
    public void delete(Long id) {


    }

    @Override
    public void transferToCard(double amount, Long fromAccountId, Long toAccountId) {

    }

    @Override
    public void transferToAccount(double amount, Client fromClient, String IBAN) {

    }
}
