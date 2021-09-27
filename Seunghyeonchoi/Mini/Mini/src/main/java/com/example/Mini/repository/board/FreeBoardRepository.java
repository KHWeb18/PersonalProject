package com.example.Mini.repository.board;

import com.example.Mini.controller.member.request.FreeRequest;
import com.example.Mini.entity.board.Free;
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
public class FreeBoardRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private HttpSession session;

    public Free select (String content) throws Exception {
        List<FreeRequest> results = jdbcTemplate.query(
                "select board_no from freeboard where content = ?",
                new RowMapper<FreeRequest>() {
                    @Override
                    public FreeRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
                        FreeRequest board = new FreeRequest();

                        board.setBoardNo(rs.getInt("board_no"));

                        log.info("**boardNo??? from repository : " + board.getBoardNo());

                        session.setAttribute("registerNo", board.getBoardNo());

                        return board;
                    }
                }, content);

        return null;
    }

    public void create(Free board) throws Exception {
        String query = "insert into freeboard (title, content, writer, nickname) values (?, ?, ?, ?)";

        jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getWriter(), board.getNickname());
    }

    public List<Free> list() throws Exception {
        List<Free> results = jdbcTemplate.query(
                "select board_no, title, content, writer, nickname, reg_date from freeboard " +
                        "where board_no > 0 order by board_no desc",
                new RowMapper<Free>() {
                    @SneakyThrows
                    @Override
                    public Free mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Free board = new Free();

                        board.setBoardNo(rs.getInt("board_no"));
                        board.setTitle(rs.getString("title"));
                        board.setContent(rs.getString("content"));
                        board.setWriter(rs.getString("writer"));
                        board.setNickname(rs.getString("nickname"));
                        board.setRegDate(rs.getDate("reg_date"));

                        return board;
                    }
                }
        );

        return results;
    }

    public Free read (Integer boardNo) throws Exception {
        List<Free> results = jdbcTemplate.query(
                "select board_no, title, content, writer, nickname, reg_date from freeboard where board_no = ?",
                new RowMapper<Free>() {
                    @Override
                    public Free mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Free board = new Free();

                        board.setBoardNo(rs.getInt("board_no"));
                        board.setTitle(rs.getString("title"));
                        board.setContent(rs.getString("content"));
                        board.setWriter(rs.getString("writer"));
                        board.setNickname(rs.getString("nickname"));
                        board.setRegDate(rs.getDate("reg_date"));

                        log.info("session.setAttribute(board.getBoardNo()) : " + board.getBoardNo());
                        session.setAttribute("boardNo", board.getBoardNo()); // comment 컨트롤러에서 쓰려고 작성

                        return board;
                    }
                }, boardNo);

        return results.isEmpty() ? null : results.get(0);
    }

    public void delete(Integer boardNo) throws Exception {
        String query = "delete from freeboard where board_no = ?";

        jdbcTemplate.update(query, boardNo);
    }

    public void update(Free board) throws Exception {
        String query = "update freeboard set title = ?, content = ? where board_no = ?";

        jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getBoardNo());
    }
}