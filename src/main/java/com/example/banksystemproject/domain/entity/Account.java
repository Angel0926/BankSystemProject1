package com.example.banksystemproject.domain.entity;

import com.example.banksystemproject.domain.enumType.BalanceType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String IBAN;

    @Column
    private Double balance=0.00;

    @Enumerated(value = EnumType.STRING)
    private BalanceType balanceType;

    @Embedded
    private IssuerBranch issuerBranch;
    @JsonManagedReference
    @OneToMany(mappedBy = "account",cascade = CascadeType.PERSIST)
    private Set<Card> cards;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JsonBackReference
    private Client client;


    public Account() {

    }

    public Account(Long id,
                   String IBAN,
                   IssuerBranch issuerBranch,
                   Client client,
                   Double balance,
                   BalanceType balanceType,
                   Set<Card> cards) {
        this.id = id;
        this.IBAN = IBAN;
        this.issuerBranch = issuerBranch;
        this.client = client;
        this.balance = balance;
        this.balanceType = balanceType;
        this.cards = cards;
    }

    public Account(String IBAN,
                   IssuerBranch issuerBranch,
                   Client client,
                   Double balance,
                   BalanceType balanceType,
                   Set<Card> cards) {
        this.IBAN = IBAN;
        this.issuerBranch = issuerBranch;
        this.client = client;
        this.balance = balance;
        this.balanceType = balanceType;
        this.cards = cards;
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

    public IssuerBranch getIssuerBranch() {
        return issuerBranch;
    }

    public void setIssuerBranch(IssuerBranch issuerBranch) {
        this.issuerBranch = issuerBranch;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }
}
