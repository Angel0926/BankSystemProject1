package com.example.banksystemproject.service.impl;

import com.example.banksystemproject.exception.ApiRequestException;
import com.example.banksystemproject.domain.entity.Account;
import com.example.banksystemproject.domain.entity.Card;

import com.example.banksystemproject.domain.enumType.CardStatus;
import com.example.banksystemproject.dto.request.CardRequestDto;
import com.example.banksystemproject.dto.responce.CardResponseDto;
import com.example.banksystemproject.repository.AccountRepo;
import com.example.banksystemproject.repository.CardRepo;
import com.example.banksystemproject.service.CardService;
import com.example.banksystemproject.util.CreditCardNumberGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.time.LocalDate;
import java.util.Optional;

@Service("card_service")
@Transactional
public class CardServiceImpl implements CardService {

    private final CardRepo cardRepo;
    private final AccountRepo accountRepo;
    private final ModelMapper modelMapper;
    private final CreditCardNumberGenerator numberGenerator;
    private final AccountServiceImpl accountService;


    @Autowired
    public CardServiceImpl(CardRepo cardRepo, AccountRepo accountRepo, ModelMapper modelMapper, CreditCardNumberGenerator numberGenerator, AccountServiceImpl accountService) {
        this.cardRepo = cardRepo;
        this.accountRepo = accountRepo;
        this.modelMapper = modelMapper;
        this.numberGenerator = numberGenerator;
        this.accountService = accountService;

    }

    @Override
    public CardResponseDto save(CardRequestDto cardRequestDto, Long accountId) throws UserPrincipalNotFoundException {
        Optional<Account> account = accountRepo.findById(accountId);
        Card card = modelMapper.map(cardRequestDto, Card.class);
        card.setCardNumber(numberGenerator.generate("905135020064", 16));
        card.setAccount(account.orElseThrow(() -> new UserPrincipalNotFoundException(String.format("Account with id %s is not found", accountId))));
        card.setExpirationDate(LocalDate.now().plusYears(5));
        Card save = cardRepo.save(card);
        CardResponseDto cardResponseDto = modelMapper.map(save, CardResponseDto.class);
        return cardResponseDto;
    }

    @Override
    public void activate(Long cardId) {
        try {
            Card card = cardRepo.findById(cardId).orElseThrow(() -> new UserPrincipalNotFoundException(String.format("Card with id %s is not found", cardId)));
      if(card.getStatus().equals(CardStatus.CREATED)){
          card.setStatus(CardStatus.ACTIVE);

      }
        } catch (UserPrincipalNotFoundException e) {
            String message = e.getName();
            throw new ApiRequestException(message);
        }

    }

    @Override
    public void block(Long cardId) {
        try {
            Card card = cardRepo.findById(cardId).orElseThrow(() -> new UserPrincipalNotFoundException(String.format("Card with id %s is not found", cardId)));
            if(card.getStatus().equals(CardStatus.ACTIVE)){
                card.setStatus(CardStatus.BLOCKED);
            }
        } catch (UserPrincipalNotFoundException e) {
            String message = e.getName();
            throw new ApiRequestException(message);
        }

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