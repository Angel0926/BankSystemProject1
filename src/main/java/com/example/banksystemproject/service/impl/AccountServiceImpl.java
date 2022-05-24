package com.example.banksystemproject.service.impl;

import com.example.banksystemproject.domain.entity.Account;
import com.example.banksystemproject.domain.entity.Client;
import com.example.banksystemproject.domain.entity.IssuerBranch;
import com.example.banksystemproject.dto.AccountDto;
import com.example.banksystemproject.repository.AccountRepo;
import com.example.banksystemproject.repository.ClientRepo;
import com.example.banksystemproject.service.AccountService;
import com.example.banksystemproject.util.IbanGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Account save(Long clientId) {
        Client client = clientRepo.getById(clientId);
        Account account = new Account();
        account.setClient(client);
        account.setIBAN(ibanGenerator.generate());
        account.setIssuerBranch(new IssuerBranch("asd","asd"));
        return accountRepo.save(account);
    }


    @Override
    public Account update(Long id, AccountDto accountDto) {
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

    public Account getById(Long accountId) {
        return accountRepo.getById(accountId);
    }
}
