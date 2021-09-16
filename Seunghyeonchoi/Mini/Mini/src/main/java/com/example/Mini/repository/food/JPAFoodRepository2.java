package com.example.Mini.repository.food;

import com.example.Mini.controller.member.request.FoodRequest;
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
public class JPAFoodRepository2 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<FoodRequest> list() throws Exception {
        // RowMapper를 통해 얻은 행을 하나씩 List에 집어넣으니
        // results엔 DB에서 얻어온 행 정보들이 들어있다.
        List<FoodRequest> results = jdbcTemplate.query(
                "select food_no, name, grade_select, gluten_free, age_select, protein, fat, mineral, fiber, moisture, calcium" +
                        ", phosphorus, kcal, introduce, diarhea, hairball, coat, palatability from food" +
                        " where food_no > 0 order by food_no desc",
//select food_no, name, grade_select, gluten_free, age, protein, fat, mineral, fiber, moisture, calcium, phosphorus, kcal, introduce from food where food_no > 0 order by food_no desc
                // Row: 행
                // 여러개의 Column(열)들이 행 1개에 포함되어 있음
                // 여러 열들을 얻어와서 행으로 맵핑하는 작업을 수행함
                new RowMapper<FoodRequest>() {
                    @SneakyThrows
                    @Override
                    public FoodRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
                        FoodRequest food = new FoodRequest();

                        food.setFoodNo(rs.getInt("food_no"));
                        food.setName(rs.getString("name"));
                        food.setGradeSelect(rs.getString("grade_select"));
                        food.setGlutenFree(rs.getString("gluten_free"));
                        food.setAgeSelect(rs.getString("age_select"));
                        food.setProtein(rs.getString("protein"));
                        food.setFat(rs.getString("fat"));
                        food.setMineral(rs.getString("mineral"));
                        food.setFiber(rs.getString("fiber"));
                        food.setMoisture(rs.getString("moisture"));
                        food.setCalcium(rs.getString("calcium"));
                        food.setPhosphorus(rs.getString("phosphorus"));
                        food.setKcal(rs.getString("kcal"));
                        food.setDiarhea(rs.getString("diarhea"));
                        food.setHairball(rs.getString("hairball"));
                        food.setCoat(rs.getString("coat"));
                        food.setPalatability(rs.getString("palatability"));
                        food.setIntroduce(rs.getString("introduce"));

                        return food;
                    }
                }
        );
        return results;
    }

    public FoodRequest read (int foodNo) throws Exception {
        List<FoodRequest> results = jdbcTemplate.query(
                "select food_no, name, grade_select, gluten_free, age_select, protein, fat, mineral, fiber, moisture, calcium, phosphorus, " +
                        "kcal, introduce, diarhea, hairball, coat, palatability from food" +
                        " where food_no = ?",
                new RowMapper<FoodRequest>() {
                    @Override
                    public FoodRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
                        FoodRequest food = new FoodRequest();

                        food.setFoodNo(rs.getInt("food_no"));
                        food.setName(rs.getString("name"));
                        food.setGradeSelect(rs.getString("grade_select"));
                        food.setGlutenFree(rs.getString("gluten_free"));
                        food.setAgeSelect(rs.getString("age_select"));
                        food.setProtein(rs.getString("protein"));
                        food.setFat(rs.getString("fat"));
                        food.setMineral(rs.getString("mineral"));
                        food.setFiber(rs.getString("fiber"));
                        food.setMoisture(rs.getString("moisture"));
                        food.setCalcium(rs.getString("calcium"));
                        food.setPhosphorus(rs.getString("phosphorus"));
                        food.setKcal(rs.getString("kcal"));
                        food.setDiarhea(rs.getString("diarhea"));
                        food.setHairball(rs.getString("hairball"));
                        food.setCoat(rs.getString("coat"));
                        food.setPalatability(rs.getString("palatability"));
                        food.setIntroduce(rs.getString("introduce"));

                        return food;
                    }
                }, foodNo);

        return results.isEmpty() ? null : results.get(0);
    }
}