package com.example.banksystemproject.service;

import com.example.banksystemproject.dto.request.AddressRequestDto;
import com.example.banksystemproject.dto.responce.AddressResponseDto;

import java.nio.file.attribute.UserPrincipalNotFoundException;


public interface AddressService {


    AddressResponseDto save(AddressRequestDto addressRequestDto);

    AddressResponseDto update(Long addressId, AddressRequestDto addressRequestDto) throws UserPrincipalNotFoundException;

    void delete(Long id) throws UserPrincipalNotFoundException;

}
