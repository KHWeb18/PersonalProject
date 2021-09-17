package com.example.writer.repository;

import com.example.writer.entity.Category;
import com.example.writer.entity.MyPageBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category findByName(String name);


}
