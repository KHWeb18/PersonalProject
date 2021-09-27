package com.example.miniproject.repository.jpa;

import com.example.miniproject.entity.Board;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class VueBoardRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Board board) throws Exception {
        String query = "insert into board (rating, area, store, content, writer) values (?, ?, ?, ? ,?)";

        jdbcTemplate.update(query,board.getRating(), board.getArea(), board.getStore(), board.getContent(), board.getWriter());
    }

    public List<Board> list() throws Exception {

        List<Board> results = jdbcTemplate.query(
                "select board_no, store, area, rating, writer, regDate from board " +
                        "where board_no > 0 order by board_no desc",
                new RowMapper<Board>() {
                    @SneakyThrows
                    @Override
                    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Board board = new Board();

                        board.setBoardNo(rs.getInt("board_no"));
                        board.setStore(rs.getString("store"));
                        board.setArea(rs.getString("area"));
                        board.setRating(rs.getFloat("rating"));
                        board.setWriter(rs.getString("writer"));


                        board.setRegDate(rs.getDate("regDate"));

                        return board;
                    }
                }
        );

        return results;
    }

    public Board read (Integer boardNo) throws Exception {
        List<Board> results = jdbcTemplate.query(
                "select board_no, area, store, rating, content, writer, regDate" +
                        " from board where board_no = ?",
                new RowMapper<Board>() {
                    @Override
                    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Board board = new Board();

                        board.setBoardNo(rs.getInt("board_no"));
                        board.setContent(rs.getString("content"));
                        board.setWriter(rs.getString("writer"));
                        board.setArea(rs.getString("area"));
                        board.setStore(rs.getString("store"));
                        board.setRating(rs.getFloat("rating"));


                        board.setRegDate(rs.getDate("regDate"));

                        return board;
                    }
                }, boardNo);

        return results.isEmpty() ? null : results.get(0);
    }

    public void delete(Integer boardNo) throws Exception {
        String query = "delete from board where board_no = ?";

        jdbcTemplate.update(query, boardNo);
    }

    public void update(Board board) throws Exception {
        String query = "update board set  content = ? where board_no = ?";

        jdbcTemplate.update(query, board.getContent(), board.getBoardNo());
    }
}