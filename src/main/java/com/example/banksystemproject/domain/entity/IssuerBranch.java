package com.example.banksystemproject.domain.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class IssuerBranch implements Serializable {

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

