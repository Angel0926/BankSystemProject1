package com.example.banksystemproject.service.impl;

import com.example.banksystemproject.domain.entity.Account;
import com.example.banksystemproject.domain.entity.Client;
import com.example.banksystemproject.dto.request.AccountRequestDto;
import com.example.banksystemproject.dto.responce.AccountResponseDto;
import com.example.banksystemproject.dto.responce.ClientAddressResponseDto;
import com.example.banksystemproject.repository.AccountRepo;
import com.example.banksystemproject.repository.ClientRepo;
import com.example.banksystemproject.service.AccountService;
import com.example.banksystemproject.util.IbanGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

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
    public AccountResponseDto save(Long clientId, AccountRequestDto accountRequestDto) throws UserPrincipalNotFoundException {
        Optional<Client> client = Optional.ofNullable(clientRepo.findById(clientId).orElseThrow(() -> new UserPrincipalNotFoundException(String.format("Client with id %s is not found", clientId))));
        Account account = new Account();
        account.setIBAN(ibanGenerator.generate());
        account.setIssuerBranch(accountRequestDto.getIssuerBranch());
        Client client1=modelMapper.map(client,Client.class);
        account.setClient(client1);
        accountRepo.save(account);
        AccountResponseDto accountResponseDto = modelMapper.map(account, AccountResponseDto.class);
        return accountResponseDto;
    }


    @Override
    public AccountResponseDto update(Long id, AccountRequestDto accountRequestDto) throws UserPrincipalNotFoundException {
        Account account = accountRepo.findById(id).orElseThrow(() -> new UserPrincipalNotFoundException(String.format("Account with id %s is not found", id)));
        account.setIssuerBranch(accountRequestDto.getIssuerBranch());
        Account save = accountRepo.save(account);
        return modelMapper.map(save, AccountResponseDto.class);
    }

    @Override
    public void delete(Long id) throws UserPrincipalNotFoundException {
        Account account = accountRepo.findById(id).orElseThrow(()
                -> new UserPrincipalNotFoundException(String.format("Account with id %s is not found", id)));

        accountRepo.delete(account);
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

    @Override
    public AccountResponseDto findById(Long id) throws UserPrincipalNotFoundException {

       Account account = accountRepo.findById(id).orElseThrow(() ->
                new UserPrincipalNotFoundException(String.format("Account with id %s is not found", id)));
        AccountResponseDto accountResponseDto=modelMapper.map(account,AccountResponseDto.class);
        return accountResponseDto;
    }}
