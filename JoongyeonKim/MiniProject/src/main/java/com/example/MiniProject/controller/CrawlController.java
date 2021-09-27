package com.example.MiniProject.controller;

import com.example.MiniProject.entity.DaumBlog;
import com.example.MiniProject.service.DaumBlogCrawlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/crawl")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class CrawlController {

    @Autowired
    DaumBlogCrawlService service;

    @GetMapping("{category}")
    public List<DaumBlog> getDaumBlogCategory(@PathVariable String category) {
        log.info("Crawling with getDaumBlogCategory(): " + category);

        service.daumBlogMainCrawler(category);

        return service.daumBlogFindAll();
    }
}
