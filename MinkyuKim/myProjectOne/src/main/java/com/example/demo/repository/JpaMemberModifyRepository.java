package com.example.demo.repository;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.entity.Member;
import com.example.demo.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Repository
public class JpaMemberModifyRepository {/*
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public MemberRequest read (String userId) throws Exception {
        List<MemberRequest> results = jdbcTemplate.query(
                "select userId, address, article, drawing, dateOfBirth, email, name, gender, largeArtwork, phoneNumber" +
                        "reg_date from member where product_no = ?",
                new RowMapper<MemberRequest>() {
                    @Override
                    public MemberRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
                        MemberRequest memberRequest = new MemberRequest();

                        memberRequest.setUserId(rs.getString("userId"));
                        memberRequest.setAddress(rs.getString("address"));
                        memberRequest.setArticle(rs.getString("article"));
                        memberRequest.setDrawing(rs.getString("drawing"));
                        memberRequest.setDateOfBirth(rs.getInt("dateOfBirth"));
                        memberRequest.setEmail(rs.getString("email"));
                        memberRequest.setName(rs.getString("name"));
                        memberRequest.setGender(rs.getString("gender"));
                        memberRequest.setLargeArtwork(rs.getString("largeArtwork"));
                        memberRequest.setPhoneNumber(rs.getInt("phoneNumber"));

                        return memberRequest;
                    }
                }, userId);

        return results.isEmpty() ? null : results.get(0);
    }
/*
    public void delete(Integer productNo) throws Exception {
        String query = "delete from member where product_no = ?";

        jdbcTemplate.update(query, productNo);
    }
*/
    /*
    public void update(MemberRequest memberRequest) throws Exception {
        String query = "update member set name = ?, dateOfBirth = ? , phoneNumber = ?," +
                "email = ?, address = ?, gender = ?, drawing = ?, article = ?, largeArtwork = ? where userId = ?";

        // log.info("member Repository: " + product);

        jdbcTemplate.update(query,memberRequest.getName(), memberRequest.getDateOfBirth(), memberRequest.getPhoneNumber(),
                memberRequest.getEmail(), memberRequest.getAddress(), memberRequest.getGender(),
                memberRequest.getDrawing(), memberRequest.getArticle(), memberRequest.getLargeArtwork());
    }*/
}
