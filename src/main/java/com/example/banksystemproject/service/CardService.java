package com.example.banksystemproject.service;

import com.example.banksystemproject.domain.entity.Client;
import com.example.banksystemproject.dto.request.CardRequestDto;
import com.example.banksystemproject.dto.responce.CardResponseDto;


public interface CardService {

    CardResponseDto save(CardRequestDto cardRequestDto, Long accountId);

    void activate(Long id);

    void block(Long id);

    void delete(Long id);

    Client findById(Long id);
}
