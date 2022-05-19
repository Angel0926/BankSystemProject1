package com.example.banksystemproject.repository;

import com.example.banksystemproject.domain.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account,Long> {
}
