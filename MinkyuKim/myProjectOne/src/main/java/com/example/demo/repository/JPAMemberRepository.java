package com.example.demo.repository;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface JPAMemberRepository extends JpaRepository<Member, Long> {

    // 조인
    @Query("select m from Member m join fetch m.authList where m.memberNo = :memberNo")
    Optional<Member> findByAuth(Long memberNo);

    // Member 전체를 가져오는데 userId 에 매칭되는 것들을 가져오라는 뜻
    @Query("select m from Member m where m.userId = :userId")
    Optional<Member> findByUserId(String userId);

    @Transactional
    @Modifying
    //@Query(value="update Member m set m.userId = :#{#member.userId} WHERE m.userId = :#{#member.userId}", nativeQuery=false)
    @Query(value="update Member m set m.userId = :#{#member.userId} WHERE m.userId = :#{#member.userId}", nativeQuery=false)
    Integer update(@Param("member") MemberRequest memberRequest );

}