package com.example.banksystemproject.service.impl;

import com.example.banksystemproject.domain.entity.Address;
import com.example.banksystemproject.domain.entity.Client;
import com.example.banksystemproject.dto.request.ClientRequestDto;
import com.example.banksystemproject.dto.request.ClientAddressRequestDto;
import com.example.banksystemproject.dto.responce.ClientAddressResponseDto;
import com.example.banksystemproject.dto.responce.ClientResponseDto;
import com.example.banksystemproject.repository.ClientRepo;
import com.example.banksystemproject.service.AddressService;
import com.example.banksystemproject.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service("client_service")
public class ClientServiceImpl implements ClientService {

    private final ClientRepo clientRepo;
    private final AddressService addressService;
    private final ModelMapper modelMapper;

    @Autowired
    public ClientServiceImpl(ClientRepo clientRepo,
                             ModelMapper modelMapper,
                             @Qualifier("address_service") AddressService addressService) {
        this.clientRepo = clientRepo;
        this.addressService = addressService;
        this.modelMapper = modelMapper;
    }



    @Override
    public ClientAddressResponseDto save(ClientAddressRequestDto clientAddressRequestDto) {
        Client client = modelMapper.map(clientAddressRequestDto.getClient(), Client.class);
        Address address = modelMapper.map(clientAddressRequestDto.getAddress(), Address.class);

        client.setAddress(address);
        Client save = clientRepo.save(client);
        return modelMapper.map(save, ClientAddressResponseDto.class);
    }

    @Override
    public ClientResponseDto update(Long id, ClientRequestDto clientDto) throws UserPrincipalNotFoundException {
        Client client = clientRepo.findById(id).orElseThrow(() -> new UserPrincipalNotFoundException(String.format("Client with id %s is not found", id)));

        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setDateOfBirth(clientDto.getDateOfBirth());
        Client save = clientRepo.save(client);
        return modelMapper.map(save,ClientResponseDto.class);
    }

    @Override
    public void delete(Long id) throws UserPrincipalNotFoundException {

        Client client = clientRepo.findById(id).orElseThrow(()
                -> new UserPrincipalNotFoundException(String.format("Client with id %s is not found", id)));

        clientRepo.delete(client);
    }

    @Override
    public ClientAddressResponseDto findById(Long id) throws UserPrincipalNotFoundException {

        Client client = clientRepo.findById(id).orElseThrow(() ->
                new UserPrincipalNotFoundException(String.format("Client with id %s is not found", id)));
        ClientAddressResponseDto clientAddressResponseDto=modelMapper.map(client,ClientAddressResponseDto.class);
        return clientAddressResponseDto;
    }

}
