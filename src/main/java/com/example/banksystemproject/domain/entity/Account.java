package com.example.banksystemproject.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

@DynamicInsert
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cards"})
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String IBAN;

    @Column
    private Double balance = 0.00;

    @Embedded
    private IssuerBranch issuerBranch;

    @JsonManagedReference
    @OneToMany(mappedBy = "account",fetch = FetchType.LAZY)
    private Set<Card> cards;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private Client client;


    public Account() {

    }

    public Account(Long id,
                   String IBAN,
                   IssuerBranch issuerBranch,
                   Client client,
                   Double balance) {
        this.id = id;
        this.IBAN = IBAN;
        this.issuerBranch = issuerBranch;
        this.client = client;
        this.balance = balance;

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

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }
}
