package com.example.foodfood.repository;

import com.example.foodfood.entity.VueMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VueJPAMemberRepository extends JpaRepository<VueMember, Long> {
}