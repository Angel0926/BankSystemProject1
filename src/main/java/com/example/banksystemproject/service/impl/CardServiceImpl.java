package com.example.banksystemproject.service.impl;

import com.example.banksystemproject.domain.entity.Card;
import com.example.banksystemproject.domain.entity.Client;
import com.example.banksystemproject.dto.CardDto;
import com.example.banksystemproject.repository.CardRepo;
import com.example.banksystemproject.service.CardService;
import com.example.banksystemproject.util.CreditCardNumberGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service("card_service")
public class CardServiceImpl implements CardService {

    private final CardRepo cardRepo;
    private final ModelMapper modelMapper;
    private final CreditCardNumberGenerator numberGenerator;
    private  final  AccountServiceImpl accountService;

    @Autowired
    public CardServiceImpl(CardRepo cardRepo, ModelMapper modelMapper, CreditCardNumberGenerator numberGenerator, AccountServiceImpl accountService) {
        this.cardRepo = cardRepo;
        this.modelMapper = modelMapper;
        this.numberGenerator = numberGenerator;
        this.accountService = accountService;
    }

    @Override
    public Card save(CardDto cardDto, Long accountId) {
        Card card = modelMapper.map(cardDto,Card.class);
        card.setCardNumber(numberGenerator.generate("905135020064",16));
        card.setAccount(accountService.getById(accountId));
        card.setExpirationDate(LocalDate.now().plusYears(5));
        return cardRepo.save(card);
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