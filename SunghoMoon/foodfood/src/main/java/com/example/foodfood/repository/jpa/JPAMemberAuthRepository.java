package com.example.foodfood.repository.jpa;

import com.example.foodfood.entity.jpa.MemberAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAMemberAuthRepository extends JpaRepository<MemberAuth, Long> {
}