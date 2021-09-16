package com.example.demo.repository.jpa;

import com.example.demo.entity.VueMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VueJPAMemberRepository extends JpaRepository<VueMember, Long> {
}