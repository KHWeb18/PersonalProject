package com.example.market3.Rapository;

import com.example.market3.Entity.JpaBeetleComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BeetleCommentsRepository extends JpaRepository<JpaBeetleComment,Long> {

    @Query("select J  from JpaBeetleComment J where J.boardNo = :boardNo")
    List<JpaBeetleComment> finyByCommentList(@Param("boardNo")Long boardNo);
}
