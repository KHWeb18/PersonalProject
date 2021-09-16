package com.example.FirstProject.repository;

import com.example.FirstProject.entity.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecommendRepository extends JpaRepository<Recommend, Long> {

    @Query("select r from Recommend r where r.id like :id")
    List<Recommend> userRead(@Param("id") String id);
}
