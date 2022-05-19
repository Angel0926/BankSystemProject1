package com.example.banksystemproject.domain.Entity;

import com.example.banksystemproject.domain.enumType.BankType;

import javax.persistence.Embeddable;

@Embeddable
public class Issuer {
    private String bankCode;

    private String bankName;

    private BankType bankType;

    public Issuer() {

        this.bankName = "UCO Bank";
        this.bankCode = "UCBA012345";
        this.bankType = bankType.COMMERCIAL_BANK;
    }
}

