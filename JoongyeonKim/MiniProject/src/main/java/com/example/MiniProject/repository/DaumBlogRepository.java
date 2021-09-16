package com.example.MiniProject.repository;


import com.example.MiniProject.entity.DaumBlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaumBlogRepository extends JpaRepository<DaumBlog, Long> {
    public DaumBlog findByBlogNo(String blogNo);
}