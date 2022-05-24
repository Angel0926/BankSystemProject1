package com.example.banksystemproject.repository;

import com.example.banksystemproject.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AccountRepo extends JpaRepository<Account,Long> {

    @Query("update Account a set a.balance = a.balance + :amount where a.id = :id")
    @Modifying
    @Transactional
    void transferTo(@Param("amount") double amount,@Param("id") Long id);

    @Query("update Account a set a.balance = a.balance - :amount where a.id = :id")
    @Modifying
    @Transactional
    void transferFrom(@Param("amount") double amount,@Param("id") Long id);


}
