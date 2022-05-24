package com.example.banksystemproject.dto.request;

import com.example.banksystemproject.dto.AddressDto;

public class CreateClientAddressDto {


    private CreateClientDto client;
    private AddressDto address;

    public CreateClientDto getClient() {
        return client;
    }

    public void setClient(CreateClientDto client) {
        this.client = client;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }
}
