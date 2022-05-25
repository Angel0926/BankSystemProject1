package com.example.banksystemproject.service;

import com.example.banksystemproject.dto.request.CardRequestDto;
import com.example.banksystemproject.dto.responce.CardResponseDto;

import java.nio.file.attribute.UserPrincipalNotFoundException;


public interface
CardService {

    CardResponseDto save(CardRequestDto cardRequestDto, Long accountId);

    void activate(Long id);

    void block(Long id);

    void delete(Long id) throws UserPrincipalNotFoundException;

    CardResponseDto findById(Long id) throws UserPrincipalNotFoundException;

    CardResponseDto update(Long id, CardRequestDto cardRequestDto) throws UserPrincipalNotFoundException;
}
