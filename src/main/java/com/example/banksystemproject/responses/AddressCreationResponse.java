package com.example.banksystemproject.responses;

import com.example.banksystemproject.dto.request.AddressRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AddressCreationResponse {
    private AddressRequestDto addressRequestDto;
    public AddressCreationResponse(AddressRequestDto addressRequestDto) {
        this.addressRequestDto = addressRequestDto;
    }

    public ResponseEntity<?> onFailure() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is an Address");
    }
    public ResponseEntity<AddressRequestDto> onSuccess(){
        return  ResponseEntity.ok().body(addressRequestDto);
    }
}
