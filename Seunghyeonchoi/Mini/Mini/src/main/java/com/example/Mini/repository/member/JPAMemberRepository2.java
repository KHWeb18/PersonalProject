package com.example.Mini.repository.member;

import com.example.Mini.controller.member.request.FoodRequest;
import com.example.Mini.controller.member.request.MemberRequest;
import com.example.Mini.controller.member.session.UserInfo;
import com.example.Mini.entity.board.Notice;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JPAMemberRepository2 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<MemberRequest> list() throws Exception {
        // RowMapper를 통해 얻은 행을 하나씩 List에 집어넣으니
        // results엔 DB에서 얻어온 행 정보들이 들어있다.
        List<MemberRequest> results = jdbcTemplate.query(
                "select member_no, user_id, nickname, reg_date from member" +
                        " where member_no > 0 order by member_no desc",

                new RowMapper<MemberRequest>() {
                    @SneakyThrows
                    @Override
                    public MemberRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
                        MemberRequest member = new MemberRequest();

                        member.setMemberNo(rs.getLong("member_no"));
                        member.setUserId(rs.getString("user_id"));
                        member.setNickname(rs.getString("nickname"));
                        member.setRegDate(rs.getDate("reg_date"));


                        return member;
                    }
                }
        );
        return results;
    }

    public void delete(Long memberNo) throws Exception {

        String query1 = "set foreign_key_checks = 0" ;
        String query = "delete from member where member_no = ? ";
        String query3 = "delete from member_auth where member_no = ? ";
        String query4 = "set foreign_key_checks = 1 ";

        jdbcTemplate.update(query1, memberNo);
        jdbcTemplate.update(query, memberNo);
        jdbcTemplate.update(query3, memberNo);
        jdbcTemplate.update(query4, memberNo);

    }

    public void update(MemberRequest memberRequest) throws Exception {
        String query = "update member set nickname = ?, password = ? where user_id = ?";

        jdbcTemplate.update(query, memberRequest.getNickname(), memberRequest.getPassword(), memberRequest.getUserId());
    }

    public void update2(MemberRequest memberRequest) throws Exception {
        String query = "update member set nickname = ? where user_id = ?";

        jdbcTemplate.update(query, memberRequest.getNickname(), memberRequest.getUserId());
    }
}