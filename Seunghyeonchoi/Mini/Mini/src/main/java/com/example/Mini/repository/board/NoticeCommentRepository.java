package com.example.Mini.repository.board;

import com.example.Mini.controller.member.request.NoticeRequest;
import com.example.Mini.entity.board.Comment;
import com.example.Mini.entity.board.Notice;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Repository
public class NoticeCommentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Comment comment) throws Exception {
        String query = "insert into noticecomment (board_no, content, writer, nickname) values (?, ?, ?, ?)";

        jdbcTemplate.update(query, comment.getBoardNo(), comment.getContent(), comment.getWriter(), comment.getNickname());
    }

    public void delete(Integer commentNo) throws Exception {
        String query = "delete from noticecomment where comment_no = ?";

        jdbcTemplate.update(query, commentNo);
    }
}