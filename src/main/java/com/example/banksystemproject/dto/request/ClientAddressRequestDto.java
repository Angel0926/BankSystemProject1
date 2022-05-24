package com.example.banksystemproject.dto.request;

public class ClientAddressRequestDto {


    private ClientRequestDto client;
    private AddressRequestDto address;

    public ClientAddressRequestDto() {
    }

    public ClientAddressRequestDto(ClientRequestDto client, AddressRequestDto address) {
        this.client = client;
        this.address = address;
    }

    public ClientRequestDto getClient() {
        return client;
    }

    public void setClient(ClientRequestDto client) {
        this.client = client;
    }

    public AddressRequestDto getAddress() {
        return address;
    }

    public void setAddress(AddressRequestDto address) {
        this.address = address;
    }
}
