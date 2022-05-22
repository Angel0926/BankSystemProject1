package com.example.banksystemproject.service.impl;

import com.example.banksystemproject.domain.entity.Card;
import com.example.banksystemproject.domain.entity.Client;
import com.example.banksystemproject.dto.request.CreateCardDto;
import com.example.banksystemproject.repository.CardRepo;
import com.example.banksystemproject.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("card_service")
public class CardServiceImpl implements CardService {

    private final CardRepo cardRepo;

    @Autowired
    public CardServiceImpl(CardRepo cardRepo) {
        this.cardRepo = cardRepo;
    }

    @Override
    public Card save(CreateCardDto cardDto) {
        return null;
    }

    @Override
    public void activate(Long id) {

    }

    @Override
    public void block(Long id) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Client findById(Long id) {
        return null;
    }
}
