package com.example.banksystemproject.controller;

import com.example.banksystemproject.domain.entity.Address;
import com.example.banksystemproject.domain.entity.Client;
import com.example.banksystemproject.dto.AddressDto;
import com.example.banksystemproject.service.AddressService;
import com.example.banksystemproject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;
    private final ClientService clientService;

    @Autowired
    public AddressController(@Qualifier("address_service") AddressService addressService, ClientService clientService) {
        this.addressService = addressService;
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Address> save(@RequestBody AddressDto addressDto,
                                        @PathVariable("id") Long id) throws UserPrincipalNotFoundException {
        Client client = clientService.findById(id);
        Address address = addressService.save(addressDto);
        client.setAddress(address);
        if (address == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.ok(address);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Address> update(@RequestBody AddressDto addressDto,
                                          @PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(addressService.update(id, addressDto));
        } catch (UserPrincipalNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {

        try {
            addressService.delete(id);
            return ResponseEntity.ok().build();

        } catch (UserPrincipalNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}

