package com.example.market3.Rapository;

import com.example.market3.Entity.JpaBoard;
import com.example.market3.Entity.JpaBoardComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface JpaBoardRepository extends JpaRepository<JpaBoard,Long> {

  //  @Query("SELECT vc.vuecount  from JpaBoard vc where vc.boardNo = :boardNo ")
   // List<JpaBoardComment> finByComments(@Param("boardNo") Long boardNo);
    @Transactional
    @Modifying
    @Query("UPDATE JpaBoard j set j.vuecount = j.vuecount +1 where j.boardNo = :boardNo")
    void updatevuecount(@Param("boardNo") Long boardNo);

    @Transactional
    @Modifying
    @Query("UPDATE JpaBoard j set j.text = :text where j.boardNo = :boardNo")
    void CommunityModify(@Param("boardNo") Long boardNo,@Param("text") String text);
}
