package com.example.banksystemproject.service;

import com.example.banksystemproject.domain.entity.Card;
import com.example.banksystemproject.domain.entity.Client;
import com.example.banksystemproject.dto.request.CreateCardDto;


public interface CardService {

    Card save(CreateCardDto cardDto);

    void activate(Long id);

    void block(Long id);

    void delete(Long id);

    Client findById(Long id);
}
