package com.example.banksystemproject.domain.entity;

import com.example.banksystemproject.domain.enumType.BalanceType;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true,length = 12)
    private String IBAN;

    @Column(nullable = false)
    private Double balance;

    @Enumerated(value = EnumType.STRING)
    @ColumnDefault("'DEBIT'")
    private BalanceType balanceType;

    @Embedded
    public IssuerBranch issuerBranch;

    @OneToMany(mappedBy = "account")
    private Set<Card> cards;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
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
