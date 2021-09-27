package com.example.miniproject.repository;

import com.example.miniproject.entity.ZowaNews;
import com.example.miniproject.entity.ZowaNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaumNewsRepository extends JpaRepository<ZowaNews, Long> {
    public ZowaNews findByNewsNo(String newsNo);
}

