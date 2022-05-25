package com.example.banksystemproject.dto.responce;

import com.example.banksystemproject.domain.entity.Client;
import com.example.banksystemproject.domain.entity.IssuerBranch;

public class AccountResponseDto {

    private Long id;

    private String IBAN;

    private Double balance;



    private IssuerBranch issuerBranch;

    private Client client;
    public AccountResponseDto() {
    }

    public AccountResponseDto(Long id, String IBAN,
                              Double balance,
                              IssuerBranch issuerBranch,
                              Client client) {
        this.id = id;
        this.IBAN = IBAN;
        this.balance = balance;
        this.issuerBranch = issuerBranch;
        this.client = client;
    }

    public AccountResponseDto(Long id, String IBAN,
                              Double balance,
                              IssuerBranch issuerBranch) {
        this.id = id;
        this.IBAN = IBAN;
        this.balance = balance;
        this.issuerBranch = issuerBranch;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }


    public IssuerBranch getIssuerBranch() {
        return issuerBranch;
    }

    public void setIssuerBranch(IssuerBranch issuerBranch) {
        this.issuerBranch = issuerBranch;
    }
}
