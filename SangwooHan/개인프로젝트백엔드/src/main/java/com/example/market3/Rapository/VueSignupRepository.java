package com.example.market3.Rapository;

import com.example.market3.Entity.Signup;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class VueSignupRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void create(Signup signup) {
        String query = "insert into vuesignup (userid, password, name, email, birthday, gender, address, phoneNo) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(query, signup.getUserid(), signup.getPassword(),
                signup.getName(),signup.getEmail(), signup.getBirthday(), signup.getGender(), signup.getAddress(), signup.getPhoneNo());
    }

    public List<Signup> list() throws Exception {

        List<Signup> results = jdbcTemplate.query(
                "select signup_no, userid, password, name, email, birthday, gender, address, phoneNo,  reg_date " +
                        "from vuesignup where signup_no > 0 order by signup_no desc",

                new RowMapper<Signup>() {
                    @SneakyThrows
                    @Override
                    public Signup mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Signup signup = new Signup();

                        signup.setBulletinNo(rs.getInt("signup_no"));
                        signup.setUserid(rs.getString("userid"));
                        signup.setPassword(rs.getString("password"));
                        signup.setName(rs.getString("name"));
                        signup.setEmail((rs.getString("email")));
                        signup.setBirthday((rs.getInt("birthday")));
                        signup.setGender(rs.getString("gender"));
                        signup.setAddress((rs.getString("address")));
                        signup.setPhoneNo((rs.getInt("phoneNo")));
                        signup.setRegdate(rs.getDate("reg_date"));

                        return signup;
                    }
                }
        );

        return results;
    }


}
