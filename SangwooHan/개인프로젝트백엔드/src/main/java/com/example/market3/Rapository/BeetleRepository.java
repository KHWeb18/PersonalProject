package com.example.market3.Rapository;

import com.example.market3.Entity.JpaBeetle;
import com.example.market3.Entity.JpaStagbeetle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface BeetleRepository extends JpaRepository<JpaBeetle,Long> {

    @Transactional
    @Modifying
    @Query("UPDATE  JpaBeetle J set J.vuecount = J.vuecount +1 where J.boardNo = :boardNo ")
    void addvueCount(@Param("boardNo")Long boardNo);

    @Query("select j from JpaBeetle j where j.title = :title")
    Optional<JpaBeetle> findBytitle(@Param("title")String title);

    @Transactional
    @Modifying
    @Query("UPDATE JpaBeetle J set J.text = :text where J.boardNo = :boardNo")
    void Modify(@Param("boardNo")Long boardNo , @Param("text") String text);
}
