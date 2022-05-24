package com.example.banksystemproject.service.impl;

import com.example.banksystemproject.domain.entity.Account;
import com.example.banksystemproject.domain.entity.Client;
import com.example.banksystemproject.dto.request.AccountRequestDto;
import com.example.banksystemproject.dto.responce.AccountResponseDto;
import com.example.banksystemproject.repository.AccountRepo;
import com.example.banksystemproject.repository.ClientRepo;
import com.example.banksystemproject.service.AccountService;
import com.example.banksystemproject.util.IbanGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("account_service")
public class AccountServiceImpl implements AccountService {

    private final AccountRepo accountRepo;
    private final ModelMapper modelMapper;

    private final ClientRepo clientRepo;
    private final IbanGenerator ibanGenerator;


    @Autowired
    public AccountServiceImpl(AccountRepo accountRepo, ModelMapper modelMapper, ClientRepo clientRepo, IbanGenerator ibanGenerator) {
        this.accountRepo = accountRepo;
        this.modelMapper = modelMapper;
        this.clientRepo = clientRepo;
        this.ibanGenerator = ibanGenerator;
    }

    @Override
    public AccountResponseDto save(Long clientId) {
        Client client = clientRepo.getById(clientId);
        Account account = new Account();
        account.setClient(client);
        account.setIBAN(ibanGenerator.generate());
        accountRepo.save(account);
        AccountResponseDto accountResponseDto = modelMapper.map(account, AccountResponseDto.class);
        return accountResponseDto;
    }


    @Override
    public Account update(Long id, AccountRequestDto accountRequestDto) {
        return null;
    }

    @Override
    public void delete(Long id) {


    }

    @Override
    @Transactional
    public void transferToCard(double amount, Long fromAccountId, Long toAccountId) {
            accountRepo.transferFrom(amount, fromAccountId);
            accountRepo.transferTo(amount, toAccountId);

    }

    @Override
    @Transactional
    public void transferToAccount(double amount, Long toAccountId) {
        accountRepo.transferTo(amount, toAccountId);
    }

    public Account getById(Long accountId) {
        return accountRepo.getById(accountId);
    }
}
