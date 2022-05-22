package com.example.banksystemproject.repository;

import com.example.banksystemproject.domain.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Long> {

}
