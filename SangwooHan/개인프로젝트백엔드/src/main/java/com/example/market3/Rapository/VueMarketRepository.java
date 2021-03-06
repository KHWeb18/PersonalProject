package com.example.market3.Rapository;

import com.example.market3.Entity.Market;
import com.example.market3.Entity.Signup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

@Slf4j
@Repository
public class VueMarketRepository {
    int num = 0;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Market market) throws Exception{
        String query = "insert into vuemarket (username ,name, price, description) values (?,?,?,?)";

        jdbcTemplate.update(query, market.getUsername(), market.getName(), market.getPrice(), market.getDescription());
    }

    public void create2(Signup signup) {
        String query = "insert into signup (userid ,password, name, birthday, gender, address, phoneNo) values (?,?,?,?,?,?,?)";

        jdbcTemplate.update(query, signup.getUserid(), signup.getPassword(), signup.getName(), signup.getBirthday(), signup.getGender(), signup.getAddress(), signup.getPhoneNo());
    }

    public  void login (Signup signup)throws  Exception{
        List<Signup> results = jdbcTemplate.query(
                "select userid, password from signup where userid = ?",

                new RowMapper<Signup>() {
                    @Override
                    public Signup mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Signup signup = new Signup();

                        signup.setUserid(rs.getString("userid"));
                        signup.setPassword(rs.getString("password"));

                        return signup;
                    }
                }, signup.getUserid());

        Signup tmp = results.get(0);
        log.info("tmp: " + tmp);

        if (tmp.getPassword().equals(signup.getPassword())) {
            log.info("Password Correct");
        } else {
            log.info("Password Incorrect");
        }
    }
    public List<Signup> memberlist() throws Exception{


        List<Signup> results = jdbcTemplate.query(
                "select userid, signup_no, reg_date from signup " +
                        "where  signup_no> 0 order by signup_no asc",

                new RowMapper<Signup>() {
                    @SneakyThrows
                    @Override
                    public Signup mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Signup signup = new Signup();

                        signup.setUserid(rs.getString("userid"));
                        signup.setBulletinNo(rs.getInt("signup_no"));

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                        signup.setRegdate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));


                        return signup;
                    }
                }
        );

        return results;
    }


    public List<Market> list() throws  Exception {

        // RowMapper??? ?????? ?????? ?????? ????????? List??? ???????????????
        // results??? DB?????? ????????? ??? ???????????? ????????????.
        List<Market> results = jdbcTemplate.query(
                "select username, market_no, name, price, description, reg_date from market " +
                        "where market_no > 0 order by market_no asc",
                // Row: ???
                // ???????????? Column(???)?????? ??? 1?????? ???????????? ??????
                // ?????? ????????? ???????????? ????????? ???????????? ????????? ?????????
                new RowMapper<Market>() {
                    @SneakyThrows
                    @Override
                    public Market mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Market market = new Market();

                        market.setUsername(rs.getString("username"));
                        market.setProductNo(rs.getInt("market_no"));
                        market.setName(rs.getString("name"));
                        market.setPrice(rs.getString("price"));
                        market.setDescription(rs.getString("description"));
                        // rs.getDate()??? DB??? ?????? ?????? ????????? ?????????

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                        market.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                        //board.setRegDate(rs.getTimestamp("reg_date"));

                        return market;
                    }
                }
        );

        return results;
    }

    public Market read (Integer productNo) throws Exception {
        List<Market> results = jdbcTemplate.query(
                "select market_no, username, name, price, description, reg_date from vuemarket where market_no = ?",
                new RowMapper<Market>() {
                    @Override
                    public Market mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Market market = new Market();

                        market.setProductNo(rs.getInt("market_no"));
                        market.setUsername(rs.getString("username"));
                        market.setName(rs.getString("name"));
                        market.setPrice(rs.getString("price"));
                        market.setDescription(rs.getString("description"));
                        market.setRegDate(rs.getDate("reg_date"));

                        return market;
                    }
                }, productNo);

        return results.isEmpty() ? null : results.get(0);
    }

    public Signup memberRead (Integer bulletinNo) throws Exception {
        List<Signup> results = jdbcTemplate.query(
                "select signup_no, userid, password, name, birthday, gender, address, phoneNo, reg_date from signup where signup_no = ?",
                new RowMapper<Signup>() {
                    @Override
                    public Signup mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Signup signup = new Signup();

                        signup.setBulletinNo(rs.getInt("signup_no"));
                        signup.setUserid(rs.getString("userid"));
                        signup.setPassword(rs.getString("password"));
                        signup.setName(rs.getString("name"));
                        signup.setBirthday(rs.getInt("birthday"));
                        signup.setGender(rs.getString("gender"));
                        signup.setAddress(rs.getString("address"));
                        signup.setPhoneNo(rs.getInt("phoneNo"));
                        signup.setRegdate(rs.getDate("reg_date"));

                        return signup;
                    }
                }, bulletinNo);

        return results.isEmpty() ? null : results.get(0);
    }




















    public  void delete(Integer productNo) throws Exception{
        String query = "delete from market where market_no = ?";

        jdbcTemplate.update(query,productNo);
    }
    public void memberDelete(Integer bulletinNo) throws Exception{
        String query = "delete from signup where signup_no = ?";
        jdbcTemplate.update(query,bulletinNo);
    }


    public void update(Market market) throws  Exception{
        String query = "update market set name = ?, price = ?, description = ? where market_no = ?";
        // where market_no = ? ???????????? ??????? ,????????? ???????????? ????????? ???????????????. ?????????

        jdbcTemplate.update(query, market.getName(), market.getPrice(), market.getDescription(), market.getProductNo());
    }

    public  void memberupdate(Signup signup) throws Exception{
        String query = "update signup set userid = ?, password = ?, name = ?, birthday = ?, gender = ?, address = ?, phoneNo = ? where signup_no = ?";
        // where market_no = ? ???????????? ??????? ,????????? ???????????? ????????? ???????????????. ?????????

        jdbcTemplate.update(query, signup.getUserid(), signup.getPassword(), signup.getName(), signup.getBirthday(), signup.getGender(), signup.getAddress(), signup.getPhoneNo(), signup.getBulletinNo());
    }

}
