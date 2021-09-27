package com.example.market3.Rapository;

import com.example.market3.Entity.JpaStagbeetleComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StagbeetleCommentRepository  extends JpaRepository<JpaStagbeetleComment,Long> {

    @Query("select cm from JpaStagbeetleComment cm where cm.boardNo = :boardNo")
    List<JpaStagbeetleComment> finyByCommentList(@Param("boardNo")Long boardNo);
}
