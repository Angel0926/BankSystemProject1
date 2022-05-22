package com.example.banksystemproject.service;

import com.example.banksystemproject.domain.entity.Client;
import com.example.banksystemproject.dto.AddressDto;
import com.example.banksystemproject.dto.request.CreateClientDto;

import java.nio.file.attribute.UserPrincipalNotFoundException;


public interface ClientService {

    Client save(CreateClientDto clientDto, AddressDto addressDto);

    Client update(Long id, CreateClientDto clientDto) throws UserPrincipalNotFoundException;

    void delete(Long id) throws UserPrincipalNotFoundException;

    Client findById(Long id) throws UserPrincipalNotFoundException;



}
