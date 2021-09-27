package com.example.foodfood.repository.jpa;

import com.example.foodfood.entity.jpa.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaAccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT a FROM Account a WHERE a.email = :email")
    Optional<Account> findByEmail(String email);
}