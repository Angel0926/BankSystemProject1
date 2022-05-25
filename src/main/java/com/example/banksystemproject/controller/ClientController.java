package com.example.banksystemproject.controller;

import com.example.banksystemproject.ExceptionHandler.ApiRequestException;
import com.example.banksystemproject.dto.request.ClientAddressRequestDto;
import com.example.banksystemproject.dto.request.ClientRequestDto;
import com.example.banksystemproject.dto.responce.ClientAddressResponseDto;
import com.example.banksystemproject.dto.responce.ClientResponseDto;
import com.example.banksystemproject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(@Qualifier(value = "client_service") ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientAddressResponseDto> save(@RequestBody ClientAddressRequestDto clientAddressRequestDto) {

        ClientAddressResponseDto clientAddressResponseDto = clientService.save(clientAddressRequestDto);
        if (clientAddressResponseDto == null) {

            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.ok(clientAddressResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDto> update(@RequestBody ClientRequestDto clientRequestDto,
                                                    @PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(clientService.update(id, clientRequestDto));
        } catch (UserPrincipalNotFoundException e) {
            String message = e.getName();
            throw new ApiRequestException(message);}
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {

        try {
            clientService.delete(id);
            return ResponseEntity.ok().build();

        } catch (UserPrincipalNotFoundException e) {
            String message = e.getName();
            throw new ApiRequestException(message);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<ClientAddressResponseDto> findById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(clientService.findById(id));
        } catch (UserPrincipalNotFoundException e) {
            String message = e.getName();
            throw new ApiRequestException(message);
        }
    }

    }

