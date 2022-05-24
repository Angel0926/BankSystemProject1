package com.example.banksystemproject.controller;

import com.example.banksystemproject.dto.request.AddressRequestDto;
import com.example.banksystemproject.dto.responce.AddressResponseDto;
import com.example.banksystemproject.dto.responce.ClientAddressResponseDto;
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
    public ResponseEntity<AddressResponseDto> save(@RequestBody AddressRequestDto addressRequestDto,
                                                   @PathVariable("id") Long id) throws UserPrincipalNotFoundException {
        ClientAddressResponseDto clientAddressResponseDto = clientService.findById(id);
        AddressResponseDto addressResponseDto = addressService.save(addressRequestDto);
        clientAddressResponseDto.setAddress(addressResponseDto);
        if (addressResponseDto == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.ok(addressResponseDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<AddressResponseDto> update(@RequestBody AddressRequestDto addressRequestDto,
                                          @PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(addressService.update(id, addressRequestDto));
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

