package com.example.banksystemproject.dto.request;

import com.example.banksystemproject.domain.entity.IssuerBranch;
import com.example.banksystemproject.domain.enumType.BalanceType;

public class AccountRequestDto {


    private IssuerBranch issuerBranch;

    private BalanceType balanceType;

    public AccountRequestDto() {
    }

    public AccountRequestDto(IssuerBranch issuerBranch, BalanceType balanceType) {
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
