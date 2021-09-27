package com.example.project1.repository.jpa;

import com.example.project1.entity.jpa.PrMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JPAMemberRepository extends JpaRepository<PrMember, Long> {

    @Query("select m from PrMember m join fetch m.authList where m.memberNo = :memberNo")
    Optional<PrMember> findByAuth(Long memberNo);

    @Query("select m from PrMember m where m.userId = :userId")
    Optional<PrMember> findByUserId(String userId);
}