package com.example.market3.Rapository;

import com.example.market3.Entity.JpaMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface JPAMemberRepository extends JpaRepository<JpaMember,Long> {

    @Query("select m from JpaMember m where m.userid = :userid")
    Optional<JpaMember>findByUserId(String userid);


    @Transactional
    @Modifying
    @Query("UPDATE JpaMember j set j.email = :email where j.memberNo = :memberNo")
    void ModfiyEmail(@Param("memberNo")Long memberNo, @Param("email") String email);




    @Transactional
    @Modifying
    @Query("UPDATE JpaMember j set j.phoneNo = :phoneNo where j.memberNo = :memberNo")
    void ModfiyPhoneNo(@Param("memberNo")Long memberNo, @Param("phoneNo") int phoneNo);

    @Transactional
    @Modifying
    @Query("UPDATE JpaMember j set j.address = :address where j.memberNo = :memberNo")
    void ModfiyAddress(@Param("memberNo")Long memberNo, @Param("address") String address);


    @Transactional
    @Modifying
    @Query("UPDATE JpaMember j set j.password = :Password where j.memberNo = :memberNo")
    void ModifyPassword(@Param("memberNo")Long memberNo, @Param("Password")String Password);

    @Query("select i.userid from JpaMember i where i.email = :email")
        List FindById(@Param("email")String email);
}
