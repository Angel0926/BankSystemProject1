package com.example.banksystemproject.repository;

import com.example.banksystemproject.domain.Entity.CardHolder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardHolderRepo extends JpaRepository<CardHolder,Long> {
}
