package com.example.banksystemproject.service;

import com.example.banksystemproject.domain.entity.Card;
import com.example.banksystemproject.domain.entity.Client;
import com.example.banksystemproject.dto.CardDto;


public interface CardService {

    Card save(CardDto cardDto, Long accountId);

    void activate(Long id);

    void block(Long id);

    void delete(Long id);

    Client findById(Long id);
}
