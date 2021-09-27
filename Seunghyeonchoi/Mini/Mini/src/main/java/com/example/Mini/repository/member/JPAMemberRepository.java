package com.example.Mini.repository.member;

import com.example.Mini.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JPAMemberRepository extends JpaRepository<Member, Long> {

    @Query("select m from Member m join fetch m.authList where m.memberNo = :memberNo")
    String findByAuth(Long memberNo);

    @Query("select m from Member m where m.userId = :userId")
    Optional<Member> findByUserId(String userId);



    @Query(value = "select member_no from member where user_id = :userId", nativeQuery = true)
    String findMeberNo(String userId);

    @Query(value = "select auth from member_auth where member_no = :memberNo", nativeQuery = true)
    String findAuth(Long memberNo);

    @Query(value = "select nickname from member where user_id = :userId", nativeQuery = true)
    String findNickname(String userId);

//    @Query(value = "select member_no, user_id, nickname, reg_date from member for json path", nativeQuery = true)
//    List list();

    @Query(value = "select JSON_OBJECT('member_no', member_no, 'user_id', user_id, 'nickname', nickname, 'reg_date', reg_date) from member;", nativeQuery = true)
    List list();

    @Query(value = "delete from member where user_id = ?", nativeQuery = true)
    String deleteUser(String userId);



}