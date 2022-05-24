package com.example.banksystemproject.dto.request;

import com.example.banksystemproject.domain.enumType.CardStatus;
import com.example.banksystemproject.domain.enumType.CardType;
import com.example.banksystemproject.dto.AccountDto;

public class CreateCardDto {

    private String pin;

    private CardType cardType;

    private CardStatus status;

    private AccountDto accountDto;


    public CreateCardDto() {
    }

    public CreateCardDto(String pin, CardType cardType, CardStatus status, AccountDto accountDto) {
        this.pin = pin;
        this.cardType = cardType;
        this.status = status;
        this.accountDto = accountDto;
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

    public AccountDto getCreateAccountDto() {
        return accountDto;
    }

    public void setCreateAccountDto(AccountDto accountDto) {
        this.accountDto = accountDto;
    }
}
