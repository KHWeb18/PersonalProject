package com.example.demo.repository.jpa;

import com.example.demo.entity.jpa.TestMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JPATestMemberRepository extends JpaRepository<TestMember, Long> {

    @Query("select mem from TestMember mem where mem.userId like %?1%")
    List<TestMember> findByJPQL(String userId);

    @Query("select mem.memberNo, mem.password from TestMember mem where mem.userId like %:userId%")
    List<Object[]> findSpecificByJPQL(@Param("userId") String userId);
}