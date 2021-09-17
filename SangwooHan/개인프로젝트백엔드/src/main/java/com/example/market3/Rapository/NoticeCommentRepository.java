package com.example.market3.Rapository;

import com.example.market3.Entity.JpaBoardComment;
import com.example.market3.Entity.JpaNoticeComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoticeCommentRepository  extends JpaRepository<JpaNoticeComment,Long> {

    @Query("SELECT cm  from JpaNoticeComment cm where cm.boardNo = :boardNo  ")
    List<JpaNoticeComment> finByNoticeComments(@Param("boardNo") Long boardNo);


}
