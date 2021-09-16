package com.example.Mini.repository;

import com.example.Mini.entity.DaumNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaumNewsRepository extends JpaRepository<DaumNews, Long> {
    public DaumNews findByNewsNo(String newsNo);
}