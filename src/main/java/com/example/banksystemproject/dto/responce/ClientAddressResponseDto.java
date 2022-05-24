package com.example.banksystemproject.dto.responce;

public class ClientAddressResponseDto {


    private ClientResponseDto client;
    private AddressResponseDto address;

    public ClientAddressResponseDto() {
    }

    public ClientAddressResponseDto(ClientResponseDto client, AddressResponseDto address) {
        this.client = client;
        this.address = address;
    }

    public ClientResponseDto getClient() {
        return client;
    }

    public void setClient(ClientResponseDto client) {
        this.client = client;
    }

    public AddressResponseDto getAddress() {
        return address;
    }

    public void setAddress(AddressResponseDto address) {
        this.address = address;
    }
}
