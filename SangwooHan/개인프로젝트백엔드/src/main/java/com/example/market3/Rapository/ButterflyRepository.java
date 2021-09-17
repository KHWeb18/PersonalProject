package com.example.market3.Rapository;

import com.example.market3.Entity.JpaButterfly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface ButterflyRepository extends JpaRepository<JpaButterfly,Long> {


    @Transactional
    @Modifying
    @Query("UPDATE  JpaButterfly J set J.vuecount = J.vuecount +1 where J.boardNo = :boardNo ")
    void vuecount(@Param("boardNo")Long boardNo);

    @Query("select j from JpaButterfly j where j.title = :title")
    Optional<JpaButterfly> findBytitle(@Param("title")String title);


    @Transactional
    @Modifying
    @Query("UPDATE  JpaButterfly J set J.text = :text where J.boardNo = :boardNo ")
    void Modify(@Param("boardNo")Long boardNo , @Param("text")String text);

}
