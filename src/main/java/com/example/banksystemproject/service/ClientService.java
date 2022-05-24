package com.example.banksystemproject.service;

import com.example.banksystemproject.dto.request.ClientAddressRequestDto;
import com.example.banksystemproject.dto.request.ClientRequestDto;
import com.example.banksystemproject.dto.responce.ClientAddressResponseDto;
import com.example.banksystemproject.dto.responce.ClientResponseDto;

import java.nio.file.attribute.UserPrincipalNotFoundException;


public interface ClientService {

    ClientAddressResponseDto save(ClientAddressRequestDto clientAddressRequestDto);

    ClientResponseDto update(Long id, ClientRequestDto clientDto) throws UserPrincipalNotFoundException;

    void delete(Long id) throws UserPrincipalNotFoundException;

    ClientAddressResponseDto findById(Long id) throws UserPrincipalNotFoundException;



}
