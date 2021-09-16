package com.example.project1.repository.jpa;

import com.example.project1.entity.jpa.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaAccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT a.email FROM PrMember a WHERE a.email = :email")
    Optional<Account> findByEmail(String email);
}