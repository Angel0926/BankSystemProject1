package com.example.banksystemproject.dto;

import com.example.banksystemproject.domain.enumType.CardStatus;
import com.example.banksystemproject.domain.enumType.CardType;

public class CardDto {

    private CardType cardType;

    private CardStatus status;
    private String cvc;
    private String pin;

    public CardDto() {
    }

    public CardDto(CardType cardType, CardStatus status, String cvc, String pin) {
        this.cardType = cardType;
        this.status = status;
        this.cvc = cvc;
        this.pin = pin;
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





