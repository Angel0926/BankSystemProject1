package com.example.banksystemproject.domain.entity;

import com.example.banksystemproject.domain.enumType.CardStatus;
import com.example.banksystemproject.domain.enumType.CardType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 16)
    private String cardNumber;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDate createdDate;

    @DateTimeFormat(pattern = "MM/yy")
    @Column(nullable = false)
    private LocalDate expirationDate;

    @Column(nullable = false, length = 3)
    private String cvc;

    @Column(nullable = false, length = 4)
    private String pin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CardType cardType;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'CREATED'")
    @Column(nullable = false)
    private CardStatus status;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Account account;


    public Card() {
    }

    public Card(Long id,
                String cardNumber,
                LocalDate createdDate,
                LocalDate expirationDate,
                String cvc,
                String pin,
                CardType cardType,
                CardStatus status,
                Account account) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.createdDate = createdDate;
        this.expirationDate = expirationDate;
        this.cvc = cvc;
        this.pin = pin;
        this.cardType = cardType;
        this.status = status;
        this.account = account;
    }

    public Card(String cardNumber,
                LocalDate createdDate,
                LocalDate expirationDate,
                String cvc,
                String pin,
                CardType cardType,
                CardStatus status,
                Account account) {
        this.cardNumber = cardNumber;
        this.createdDate = createdDate;
        this.expirationDate = expirationDate;
        this.cvc = cvc;
        this.pin = pin;
        this.cardType = cardType;
        this.status = status;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public CardStatus getStatus() {
        return status;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
