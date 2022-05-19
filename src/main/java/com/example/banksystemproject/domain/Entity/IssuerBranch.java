package com.example.banksystemproject.domain.Entity;

import com.example.banksystemproject.domain.enumType.BankType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "card_holder")
public class IssuerBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "bank_code", nullable = false, length = 10)
    private String bankCode;

    @Column(name = "bank_name", nullable = false, length = 30)
    private String bankName;

    @Column(name = "bank_type", nullable = false)
    private BankType bankType;

    @OneToMany(mappedBy = "issuerBranch",cascade = CascadeType.PERSIST)
    private List<Account> accountList=new ArrayList<>();

    @OneToMany(mappedBy = "issuerBranch",cascade = CascadeType.PERSIST)
    private List<Card> cardList=new ArrayList<>();

}

