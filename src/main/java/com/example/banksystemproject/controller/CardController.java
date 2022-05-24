package com.example.banksystemproject.controller;

import com.example.banksystemproject.domain.entity.Card;
import com.example.banksystemproject.dto.CardDto;
import com.example.banksystemproject.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(@Qualifier(value = "card_service") CardService cardService) {
        this.cardService = cardService;
    }


    @PostMapping("/{id}")
    public ResponseEntity<Card> save(@RequestBody CardDto cardDto,
                                     @PathVariable("id") Long accountId) {
        Card card = cardService.save(cardDto, accountId);
        if (card == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.ok(card);
    }


}
