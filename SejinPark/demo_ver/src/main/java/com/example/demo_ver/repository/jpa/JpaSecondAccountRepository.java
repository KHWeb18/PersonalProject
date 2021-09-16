package com.example.demo_ver.repository.jpa;

import com.example.demo_ver.entity.jpa.SecondAccount;
import com.example.demo_ver.entity.jpa.SecondAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaSecondAccountRepository extends JpaRepository<SecondAccount, Long> {

    @Query("SELECT a FROM SecondAccount a WHERE a.email = :email")
    Optional<SecondAccount> findByEmail(String email);
}