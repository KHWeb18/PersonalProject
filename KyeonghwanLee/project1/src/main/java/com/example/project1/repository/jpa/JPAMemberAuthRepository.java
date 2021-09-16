
package com.example.project1.repository.jpa;

import com.example.project1.entity.jpa.PrMember;
import com.example.project1.entity.jpa.PrMemberAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface JPAMemberAuthRepository extends JpaRepository<PrMemberAuth, Long> {
}