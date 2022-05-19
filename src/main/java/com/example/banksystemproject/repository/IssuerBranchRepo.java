package com.example.banksystemproject.repository;

import com.example.banksystemproject.domain.Entity.IssuerBranch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssuerBranchRepo extends JpaRepository<IssuerBranch, Long> {
}
