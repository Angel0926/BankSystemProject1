package com.example.banksystemproject.service;

import com.example.banksystemproject.domain.entity.Address;
import com.example.banksystemproject.dto.AddressDto;


public interface AddressService {

    Address save(AddressDto addressDto);

    Address update(Long addressId, AddressDto addressDto);

    void delete(Long id);

}
