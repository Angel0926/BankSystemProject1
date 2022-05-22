package com.example.banksystemproject.dto.request;

public class CreateAccountDto {


    private String IBAN;

    private CreateClientDto clientDto;

    private Double balance;

    public CreateAccountDto(String IBAN, CreateClientDto clientDto, Double balance) {
        this.IBAN = IBAN;
        this.clientDto = clientDto;
        this.balance = balance;
    }

    public CreateAccountDto() {
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public CreateClientDto getClientDto() {
        return clientDto;
    }

    public void setClientDto(CreateClientDto clientDto) {
        this.clientDto = clientDto;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
