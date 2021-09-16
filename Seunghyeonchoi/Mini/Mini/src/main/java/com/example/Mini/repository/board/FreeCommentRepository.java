package com.example.Mini.repository.board;

import com.example.Mini.entity.board.Comment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class FreeCommentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Comment comment) throws Exception {
        String query = "insert into freecomment (board_no, content, writer, nickname) values (?, ?, ?, ?)";

        jdbcTemplate.update(query, comment.getBoardNo(), comment.getContent(), comment.getWriter(), comment.getNickname());
    }

    public void delete(Integer commentNo) throws Exception {
        String query = "delete from freecomment where comment_no = ?";

        jdbcTemplate.update(query, commentNo);
    }
}