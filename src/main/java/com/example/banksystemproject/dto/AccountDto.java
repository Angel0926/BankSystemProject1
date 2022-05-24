package com.example.banksystemproject.dto;

import com.example.banksystemproject.domain.entity.IssuerBranch;
import com.example.banksystemproject.domain.enumType.BalanceType;

public class AccountDto {


    private IssuerBranch issuerBranch;

    private BalanceType balanceType;

    public AccountDto() {
    }

    public AccountDto(IssuerBranch issuerBranch, BalanceType balanceType) {
        this.issuerBranch = issuerBranch;
        this.balanceType = balanceType;
    }

    public IssuerBranch getIssuerBranch() {
        return issuerBranch;
    }

    public void setIssuerBranch(IssuerBranch issuerBranch) {
        this.issuerBranch = issuerBranch;
    }

    public BalanceType getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(BalanceType balanceType) {
        this.balanceType = balanceType;
    }
}
