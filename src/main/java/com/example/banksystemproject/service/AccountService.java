package com.example.banksystemproject.service;

import com.example.banksystemproject.domain.entity.Account;
import com.example.banksystemproject.dto.request.AccountRequestDto;
import com.example.banksystemproject.dto.responce.AccountResponseDto;


public interface AccountService {

    AccountResponseDto save(Long clientId) ;

    Account update(Long id, AccountRequestDto accountRequestDto);

    void delete(Long id);

    void transferToCard(double amount,Long fromAccountId,Long toAccountId);


    void transferToAccount(double amount, Long toAccountId);
}
