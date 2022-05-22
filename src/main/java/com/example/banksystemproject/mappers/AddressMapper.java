package com.example.banksystemproject.mappers;

import com.example.banksystemproject.domain.entity.Address;
import com.example.banksystemproject.dto.AddressDto;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public Address toAddress(AddressDto addressDto){
        Address address=new Address();

        address.setStreet(addressDto.getStreet());
        address.setCity(addressDto.getCity());
        address.setCountry(addressDto.getCountry());
        return address;
    }

    public AddressDto toAddressDto(Address address){
        AddressDto addressDto=new AddressDto();

        addressDto.setStreet(address.getStreet());
        addressDto.setCity(address.getCity());
        addressDto.setCountry(address.getCountry());
        return addressDto;
    }
}
