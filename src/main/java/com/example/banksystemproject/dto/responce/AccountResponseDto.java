package com.example.banksystemproject.dto.responce;

import com.example.banksystemproject.domain.entity.IssuerBranch;
import com.example.banksystemproject.domain.enumType.BalanceType;

public class AccountResponseDto {

    private Long id;

    private String IBAN;

    private Double balance = 0.00;

    private BalanceType balanceType = BalanceType.CREDIT;


    private IssuerBranch issuerBranch;


    public AccountResponseDto() {
    }

    public AccountResponseDto(Long id, String IBAN,
                              Double balance,
                              BalanceType balanceType,
                              IssuerBranch issuerBranch) {
        this.id = id;
        this.IBAN = IBAN;
        this.balance = balance;
        this.balanceType = balanceType;
        this.issuerBranch = issuerBranch;
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

    public BalanceType getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(BalanceType balanceType) {
        this.balanceType = balanceType;
    }

    public IssuerBranch getIssuerBranch() {
        return issuerBranch;
    }

    public void setIssuerBranch(IssuerBranch issuerBranch) {
        this.issuerBranch = issuerBranch;
    }
}
