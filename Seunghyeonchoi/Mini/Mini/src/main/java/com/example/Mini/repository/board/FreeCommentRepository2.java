package com.example.Mini.repository.board;

import com.example.Mini.entity.board.Comment;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Slf4j
public class FreeCommentRepository2 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Comment> list(int boardNo) throws Exception {
        List<Comment> results = jdbcTemplate.query(
                "select comment_no, board_no, content, writer, nickname, reg_date from freecomment" +
                        " where board_no = ? and comment_no > 0 order by comment_no ASC",
                new RowMapper<Comment>() {
                    @SneakyThrows
                    @Override
                    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Comment comment = new Comment();

                        comment.setCommentNo(rs.getInt("comment_no"));
                        comment.setBoardNo(rs.getInt("board_no"));
                        comment.setContent(rs.getString("content"));
                        comment.setWriter(rs.getString("writer"));
                        comment.setNickname(rs.getString("nickname"));
                        comment.setRegDate(rs.getTimestamp("reg_date"));

                        return comment;
                    }
                }, boardNo);
        return results;
    }
}