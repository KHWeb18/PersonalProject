package com.pettalk.pettalkbackend.repository;

import com.pettalk.pettalkbackend.dto.BoardType;
import com.pettalk.pettalkbackend.entity.Comment;
import com.pettalk.pettalkbackend.repository.custom.CommentRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>, CommentRepositoryCustom {
    public List<Comment> findByBoardTypeAndBoardNo(BoardType boardType, Long boardNo);
}
