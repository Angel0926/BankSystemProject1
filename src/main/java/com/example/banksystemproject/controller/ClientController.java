package com.example.banksystemproject.controller;

import com.example.banksystemproject.domain.entity.Client;
import com.example.banksystemproject.dto.request.CreateClientAddressDto;
import com.example.banksystemproject.dto.request.CreateClientDto;
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
    public ResponseEntity<Client> save(@RequestBody CreateClientAddressDto createClientAddressDto) {

        Client client = clientService.save(createClientAddressDto);
        if (client == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.ok(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@RequestBody CreateClientDto createClientDto,
                                         @PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(clientService.update(id, createClientDto));
        } catch (UserPrincipalNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {

        try {
            clientService.delete(id);
            return ResponseEntity.ok().build();

        } catch (UserPrincipalNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable("id") Long id) {

        try {
            return ResponseEntity.ok(clientService.findById(id));

        } catch (UserPrincipalNotFoundException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
