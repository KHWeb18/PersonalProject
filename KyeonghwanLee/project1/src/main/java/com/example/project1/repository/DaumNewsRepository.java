package com.example.project1.repository;

import com.example.project1.entity.ProjectDaumNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaumNewsRepository extends JpaRepository<ProjectDaumNews, Long> {
    public ProjectDaumNews findByNewsNo(String newsNo);
}