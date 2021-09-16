package com.example.Mini.repository.food;

import com.example.Mini.entity.food.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JPAFoodRepository extends JpaRepository<Food, Long> {

    @Query(value = "select food_no from food where name = :name", nativeQuery = true)
    int findFoodNo(String name);


}