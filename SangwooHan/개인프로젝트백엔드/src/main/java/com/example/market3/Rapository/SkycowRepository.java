package com.example.market3.Rapository;

import com.example.market3.Entity.JpaSkycow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import javax.transaction.Transactional;
import java.util.Optional;

public interface SkycowRepository extends JpaRepository<JpaSkycow,Long> {

    @Transactional
    @Modifying
    @Query("UPDATE  JpaSkycow J set J.vuecount = J.vuecount +1 where J.boardNo = :boardNo ")
    void vuecount(@Param("boardNo")Long boardNo);


    @Query("select j from JpaSkycow j where j.title = :title")
    Optional<JpaSkycow>findBytitle(@Param("title")String title);

    @Transactional
    @Modifying
    @Query("UPDATE JpaSkycow J set J.text  = :text where J.boardNo = :boardNo")
    void Modify(@Param("boardNo")Long boardNo,@Param("text")String text);
}
