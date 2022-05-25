package com.example.banksystemproject.dto.responce;

import com.example.banksystemproject.domain.entity.Account;
import com.example.banksystemproject.domain.enumType.CardStatus;
import com.example.banksystemproject.domain.enumType.CardType;

public class CardResponseDto {
    private Long id;
    private CardType cardType;

    private CardStatus status;
    private String cvc;
    private String pin;

    private Account account;

    public CardResponseDto() {
    }

    public CardResponseDto(Long id, CardType cardType, CardStatus status, String cvc, String pin, Account account) {
        this.id = id;
        this.cardType = cardType;
        this.status = status;
        this.cvc = cvc;
        this.pin = pin;
        this.account = account;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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
}





