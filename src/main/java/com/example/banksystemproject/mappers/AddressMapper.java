package com.example.banksystemproject.mappers;

import com.example.banksystemproject.domain.entity.Address;
import com.example.banksystemproject.dto.request.AddressRequestDto;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public Address toAddress(AddressRequestDto addressRequestDto){
        Address address=new Address();

        address.setStreet(addressRequestDto.getStreet());
        address.setCity(addressRequestDto.getCity());
        address.setCountry(addressRequestDto.getCountry());
        return address;
    }

    public AddressRequestDto toAddressDto(Address address){
        AddressRequestDto addressRequestDto =new AddressRequestDto();

        addressRequestDto.setStreet(address.getStreet());
        addressRequestDto.setCity(address.getCity());
        addressRequestDto.setCountry(address.getCountry());
        return addressRequestDto;
    }
}
