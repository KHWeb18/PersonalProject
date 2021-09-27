package com.example.MiniProject.repository.funding;

import com.example.MiniProject.entity.funding.Funding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface FundingRepository extends JpaRepository<Funding, Long> {

    //@Query("select m from Member m join fetch m.authList where m.memberNo = :memberNo")
    //Optional<Member> findByAuth(Long memberNo);

    //read
    @Query("select m from Funding m where m.fundingNo = :fundingNo")
    List<Funding> findByFunding(Long fundingNo);

    //modify
    @Query("select m from Funding m where m.fundingNo = :fundingNo")
    List<Funding> findByRead(Long fundingNo);

    //pay
    @Query("select m from Funding m where m.fundingNo = :fundingNo")
    List<Funding> plusByMoney(Long fundingNo);

}
