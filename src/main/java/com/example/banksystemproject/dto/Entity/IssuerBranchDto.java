package com.example.banksystemproject.dto.Entity;

import com.example.banksystemproject.domain.enumType.BankType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "issuer_branch")
public class IssuerBranchDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "bank_code", nullable = false, length = 5)
    private String bankCode;

    @Column(name = "bank_name", nullable = false, length = 30)
    private String bankName;

    @Enumerated(EnumType.STRING)
    @Column(name = "bank_type", nullable = false)
    private BankType bankType;

    @OneToMany(mappedBy = "issuerBranch",cascade = CascadeType.PERSIST)
    private List<AccountDto> accountList=new ArrayList<>();

    @OneToMany(mappedBy = "issuerBranch",cascade = CascadeType.PERSIST)
    private List<CardDto> cardList=new ArrayList<>();

}

