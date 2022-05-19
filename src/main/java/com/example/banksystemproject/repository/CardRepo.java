package com.example.banksystemproject.repository;

import com.example.banksystemproject.domain.Entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepo extends JpaRepository<Card,Long> {
}
