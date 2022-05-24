package com.example.banksystemproject.service;

import com.example.banksystemproject.domain.entity.Address;
import com.example.banksystemproject.dto.AddressDto;

import java.nio.file.attribute.UserPrincipalNotFoundException;


public interface AddressService {


    Address save(AddressDto addressDto);

    Address update(Long addressId, AddressDto addressDto) throws UserPrincipalNotFoundException;

    void delete(Long id) throws UserPrincipalNotFoundException;

}
