package com.example.springbackend.repository;

import com.example.springbackend.entity.Board;
import com.example.springbackend.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    @Query("select c from Comment c where  c.board_no = :boardNo")
    public List<Comment> getCommentsOfBoard(Long boardNo);

    @Query("select c from Comment c where c.commentNo = :commentNo")
    public List<Comment> findByCommentNo(Long commentNo);

    @Transactional
    @Modifying
    @Query(value = "delete from Comment where board_no =:board_no")
    void deleteByBoardNo(@Param("board_no")Long board_no);
}

