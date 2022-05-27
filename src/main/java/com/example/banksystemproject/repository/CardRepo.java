package com.example.banksystemproject.repository;

import com.example.banksystemproject.domain.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository

public interface CardRepo extends JpaRepository<Card,Long> {

}
