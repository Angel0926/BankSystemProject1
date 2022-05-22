package com.example.banksystemproject.domain.entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Embeddable;

@Embeddable
public class IssuerBranch {

    @ColumnDefault("'12650'")
    private String bankCode;

    @ColumnDefault("'AEF BANK'")
    private String bankName;

    public IssuerBranch(String bankCode, String bankName) {
        this.bankCode = bankCode;
        this.bankName = bankName;
    }

    public IssuerBranch() {

    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}

