package com.example.banksystemproject.service.impl;

import com.example.banksystemproject.domain.entity.Address;
import com.example.banksystemproject.dto.AddressDto;
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
    public Address save(AddressDto addressDto) {

        return addressRepo.save(modelMapper.map(addressDto,Address.class));
    }

    @Override
    public Address update(Long addressId, AddressDto addressDto) throws UserPrincipalNotFoundException {
        Address address = addressRepo.findById(addressId).orElseThrow(() -> new UserPrincipalNotFoundException(String.format("Address with id %s is not found", addressId)));

        address.setCountry(addressDto.getCountry());
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());

        return addressRepo.save(address);
    }
    @Override
    public void delete(Long id) throws UserPrincipalNotFoundException {
        Address  address= addressRepo.findById(id).orElseThrow(()
                -> new UserPrincipalNotFoundException(String.format("Address with id %s is not found", id)));

        addressRepo.delete(address);
    }

}
