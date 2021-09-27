package com.example.market3.Rapository;

import com.example.market3.Entity.JpaNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface JpaNoticeRepository extends JpaRepository<JpaNotice,Long> {

    @Transactional
    @Modifying
    @Query("UPDATE JpaNotice j set j.vuecount = j.vuecount +1 where j.boardNo = :boardNo")
    void NoticeaddVueCount(@Param("boardNo") Long boardNo);
}
