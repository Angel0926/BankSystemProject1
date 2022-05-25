package com.example.banksystemproject.service.impl;

import com.example.banksystemproject.domain.entity.Card;
import com.example.banksystemproject.dto.request.CardRequestDto;
import com.example.banksystemproject.dto.responce.CardResponseDto;
import com.example.banksystemproject.repository.CardRepo;
import com.example.banksystemproject.service.CardService;
import com.example.banksystemproject.util.CreditCardNumberGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.time.LocalDate;

@Service("card_service")
public class CardServiceImpl implements CardService {

    private final CardRepo cardRepo;
    private final ModelMapper modelMapper;
    private final CreditCardNumberGenerator numberGenerator;
    private final AccountServiceImpl accountService;

    @Autowired
    public CardServiceImpl(CardRepo cardRepo, ModelMapper modelMapper, CreditCardNumberGenerator numberGenerator, AccountServiceImpl accountService) {
        this.cardRepo = cardRepo;
        this.modelMapper = modelMapper;
        this.numberGenerator = numberGenerator;
        this.accountService = accountService;
    }

    @Override
    public CardResponseDto save(CardRequestDto cardRequestDto, Long accountId) {
        Card card = modelMapper.map(cardRequestDto, Card.class);
        card.setCardNumber(numberGenerator.generate("905135020064", 16));
        card.setAccount(accountService.getById(accountId));
        card.setExpirationDate(LocalDate.now().plusYears(5));
        Card save = cardRepo.save(card);
        CardResponseDto cardResponseDto = modelMapper.map(save, CardResponseDto.class);
        return cardResponseDto;
    }

    @Override
    public void activate(Long id) {

    }

    @Override
    public void block(Long id) {

    }

    @Override
    public void delete(Long id) throws UserPrincipalNotFoundException {
        Card card= cardRepo.findById(id).orElseThrow(()
                -> new UserPrincipalNotFoundException(String.format("Card with id %s is not found", id)));

        cardRepo.delete(card);
    }

    @Override
    public CardResponseDto findById(Long id) throws UserPrincipalNotFoundException {
        Card card = cardRepo.findById(id).orElseThrow(() ->
                new UserPrincipalNotFoundException(String.format("Card with id %s is not found", id)));
        CardResponseDto cardResponseDto=modelMapper.map(card,CardResponseDto.class);
        return cardResponseDto;

    }

    @Override
    public CardResponseDto update(Long id, CardRequestDto cardRequestDto) throws UserPrincipalNotFoundException {
        Card card = cardRepo.findById(id).orElseThrow(() -> new UserPrincipalNotFoundException(String.format("Card with id %s is not found", id)));

        card.setCardType(cardRequestDto.getCardType());
        card.setStatus(cardRequestDto.getStatus());
        card.setCvc(cardRequestDto.getCvc());
        card.setPin(cardRequestDto.getPin());
        Card save = cardRepo.save(card);
        return modelMapper.map(save,CardResponseDto.class);
    }

}