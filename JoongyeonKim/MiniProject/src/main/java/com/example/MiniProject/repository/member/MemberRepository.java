package com.example.MiniProject.repository.member;

import com.example.MiniProject.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    //고객과 관리자를 구분하는 쿼리
    @Query("select m from Member m join fetch m.authList where m.memberNo = :memberNo")
    Optional<Member> findByAuth(Long memberNo);

    //로그인 쿼리
    @Query("select m from Member m where m.email = :email")
    Optional<Member> findByEmail(String email);

    //회원가입 중복방지 강사님이 로그인 쿼리 그대로쓰고 이름만 바꾸면 됨 findByEmailCheck의 대응메소드를 만들어야함
    @Query("select m from Member m where m.email = :email")
    List<Member> findByEmailCheck(String email);

}
