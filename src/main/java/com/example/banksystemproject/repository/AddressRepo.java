package com.example.banksystemproject.repository;

import com.example.banksystemproject.domain.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Long> {
}
