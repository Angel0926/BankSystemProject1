package com.example.banksystemproject.dto.request;

import com.example.banksystemproject.domain.enumType.CardStatus;
import com.example.banksystemproject.domain.enumType.CardType;

public class CreateCardDto {

    private String pin;

    private CardType cardType;

    private CardStatus status;

    private CreateAccountDto createAccountDto;


    public CreateCardDto() {
    }

    public CreateCardDto(String pin, CardType cardType, CardStatus status, CreateAccountDto createAccountDto) {
        this.pin = pin;
        this.cardType = cardType;
        this.status = status;
        this.createAccountDto = createAccountDto;
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

    public CreateAccountDto getCreateAccountDto() {
        return createAccountDto;
    }

    public void setCreateAccountDto(CreateAccountDto createAccountDto) {
        this.createAccountDto = createAccountDto;
    }
}
