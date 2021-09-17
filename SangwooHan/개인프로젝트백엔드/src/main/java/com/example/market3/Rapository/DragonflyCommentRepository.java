package com.example.market3.Rapository;

import com.example.market3.Entity.JpaDragonflyComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DragonflyCommentRepository extends JpaRepository<JpaDragonflyComment,Long> {

    @Query("select cm from JpaDragonflyComment cm where cm.boardNo = :boardNo")
    List<JpaDragonflyComment> findBycomment(@Param("boardNo")Long boardNo);
}
