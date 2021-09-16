package com.example.demo.repository;

import com.example.demo.entity.Board;
import com.example.demo.entity.Gongzi;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GongziRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Gongzi gongzi) throws Exception {

        String query = "insert into gongzi (title, content, writer) values (?, ?, ?)";

        jdbcTemplate.update(query, gongzi.getTitle(), gongzi.getContent(), gongzi.getWriter());
    }
    public List<Gongzi> list() throws Exception {

        List<Gongzi> results = jdbcTemplate.query(
                "select gongzi_no, title, content, writer,regDate from gongzi " +
                        "where gongzi_no > 0 order by gongzi_no desc",

                new RowMapper<Gongzi>() {
                    @SneakyThrows
                    @Override
                    public Gongzi mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Gongzi gongzi = new Gongzi();


                        gongzi.setGongziNo(rs.getInt("gongzi_no"));
                        gongzi.setTitle(rs.getString("title"));
                        gongzi.setContent(rs.getString("content"));
                        gongzi.setWriter(rs.getString("writer"));
                        gongzi.setRegDate(rs.getDate("regDate"));


                        return gongzi;
                    }
                }
        );

        return results;
    }
    public Gongzi read (Integer gongziNo) throws Exception {
        List<Gongzi> results = jdbcTemplate.query(
                "select gongzi_no, title, content, writer, regDate from gongzi where gongzi_no = ?",
                new RowMapper<Gongzi>() {
                    @Override
                    public Gongzi mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Gongzi gongzi = new Gongzi();

                        gongzi.setGongziNo(rs.getInt("gongzi_no"));
                        gongzi.setTitle(rs.getString("title"));
                        gongzi.setContent(rs.getString("content"));
                        gongzi.setWriter(rs.getString("writer"));
                        gongzi.setRegDate(rs.getDate("regDate"));

                        return gongzi;
                    }
                }, gongziNo);

        return results.isEmpty() ? null : results.get(0);
    }

    public void delete(Integer gongziNo) throws  Exception {
        String query = "delete from gongzi where gongzi_no = ?";
        jdbcTemplate.update(query, gongziNo);
    }

    public void update(Gongzi gongzi) throws Exception {
        String query = "update gongzi set title = ?, content = ? where gongzi_no = ?";
        jdbcTemplate.update(query,gongzi.getTitle(),gongzi.getContent(),gongzi.getGongziNo());

    }

}

