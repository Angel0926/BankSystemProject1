package com.example.banksystemproject.responses;

import com.example.banksystemproject.dto.AddressDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AddressCreationResponse {
    private AddressDto addressDto;
    public AddressCreationResponse(AddressDto addressDto) {
        this.addressDto=addressDto;
    }

    public ResponseEntity<?> onFailure() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is an Address");
    }
    public ResponseEntity<AddressDto> onSuccess(){
        return  ResponseEntity.ok().body(addressDto);
    }
}
