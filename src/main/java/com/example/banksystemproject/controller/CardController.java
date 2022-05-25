package com.example.banksystemproject.controller;

import com.example.banksystemproject.ExceptionHandler.ApiRequestException;
import com.example.banksystemproject.dto.request.AccountRequestDto;
import com.example.banksystemproject.dto.request.CardRequestDto;
import com.example.banksystemproject.dto.responce.AccountResponseDto;
import com.example.banksystemproject.dto.responce.CardResponseDto;
import com.example.banksystemproject.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestController
@RequestMapping("/card")
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(@Qualifier(value = "card_service") CardService cardService) {
        this.cardService = cardService;
    }


    @PostMapping("/{id}")
    public ResponseEntity<CardResponseDto> save(@RequestBody CardRequestDto cardRequestDto,
                                     @PathVariable("id") Long accountId) {
        CardResponseDto cardResponseDto = null;
        try {
            cardResponseDto = cardService.save(cardRequestDto, accountId);
        } catch (UserPrincipalNotFoundException e) {
            String message = e.getName();
            throw new ApiRequestException(message);
        }
        if (cardResponseDto == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.ok(cardResponseDto);
    }


    @DeleteMapping("/{id}")

    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            cardService.delete(id);
            return ResponseEntity.ok().build();

        } catch (UserPrincipalNotFoundException e) {
            String message = e.getName();
            throw new ApiRequestException(message);
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<CardResponseDto> update(@RequestBody CardRequestDto cardRequestDto,
                                                    @PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(cardService.update(id,cardRequestDto));
        } catch (UserPrincipalNotFoundException e) {
            String message = e.getName();
            throw new ApiRequestException(message);}
    }

    @PostMapping("/activate")

    public ResponseEntity<?> activateCard(@RequestParam Long cardId){

            cardService.activate(cardId);
            return ResponseEntity.ok().build();
    }

    @PostMapping("/blocked")

    public ResponseEntity<?> blockedCard(@RequestParam Long cardId){

        cardService.block(cardId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardResponseDto> findById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(cardService.findById(id));
        } catch (UserPrincipalNotFoundException e) {
            String message = e.getName();
            throw new ApiRequestException(message);
        }
    }

}
