package com.example.banksystemproject.service.impl;

import com.example.banksystemproject.domain.entity.Address;
import com.example.banksystemproject.dto.request.AddressRequestDto;
import com.example.banksystemproject.dto.responce.AddressResponseDto;
import com.example.banksystemproject.repository.AddressRepo;
import com.example.banksystemproject.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service("address_service")
public class AddressServiceImpl implements AddressService {

    private final AddressRepo addressRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public AddressServiceImpl(AddressRepo addressRepo, ModelMapper modelMapper) {
        this.addressRepo = addressRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public AddressResponseDto save(AddressRequestDto addressRequestDto) {

        Address save = addressRepo.save(modelMapper.map(addressRequestDto, Address.class));
        return modelMapper.map(save,AddressResponseDto.class);
    }

    @Override
    public AddressResponseDto update(Long addressId, AddressRequestDto addressRequestDto) throws UserPrincipalNotFoundException {
        Address address = addressRepo.findById(addressId).orElseThrow(() -> new UserPrincipalNotFoundException(String.format("Address with id %s is not found", addressId)));

        address.setCountry(addressRequestDto.getCountry());
        address.setCity(addressRequestDto.getCity());
        address.setStreet(addressRequestDto.getStreet());
        Address save = addressRepo.save(address);
        return modelMapper.map(save,AddressResponseDto.class);
    }
    @Override
    public void delete(Long id) throws UserPrincipalNotFoundException {
        Address  address= addressRepo.findById(id).orElseThrow(()
                -> new UserPrincipalNotFoundException(String.format("Address with id %s is not found", id)));

        addressRepo.delete(address);
    }

}
