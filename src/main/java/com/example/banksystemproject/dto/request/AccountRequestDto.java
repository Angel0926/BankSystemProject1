package com.example.banksystemproject.dto.request;

import com.example.banksystemproject.domain.entity.IssuerBranch;

import javax.persistence.Column;

public class AccountRequestDto {

    @Column
    private IssuerBranch issuerBranch;


    public AccountRequestDto() {
    }

    public AccountRequestDto(IssuerBranch issuerBranch) {
        this.issuerBranch = issuerBranch;
    }

    public IssuerBranch getIssuerBranch() {
        return issuerBranch;
    }

    public void setIssuerBranch(IssuerBranch issuerBranch) {
        this.issuerBranch = issuerBranch;
    }

}
