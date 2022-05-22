package com.example.banksystemproject.dto.responce;

import com.example.banksystemproject.domain.enumType.CardStatus;
import com.example.banksystemproject.domain.enumType.CardType;
import com.example.banksystemproject.dto.request.CreateAccountDto;

import java.time.LocalDate;


public class CardResponseDto {


    private Long id;

    private String cardNumber;

    private LocalDate expirationDate;

    private CardType cardType;

    private CardStatus status;

    private CreateAccountDto createAccountDto;

    public CardResponseDto() {
    }

    public CardResponseDto(Long id, String cardNumber, LocalDate expirationDate, CardType cardType, CardStatus status, CreateAccountDto createAccountDto) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cardType = cardType;
        this.status = status;
        this.createAccountDto = createAccountDto;
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

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
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





