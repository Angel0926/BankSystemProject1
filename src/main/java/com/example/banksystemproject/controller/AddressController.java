package com.example.banksystemproject.controller;

import com.example.banksystemproject.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(@Qualifier("address_service") AddressService addressService) {
        this.addressService = addressService;
    }


}

