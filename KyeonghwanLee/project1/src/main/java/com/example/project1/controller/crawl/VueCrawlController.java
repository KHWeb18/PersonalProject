package com.example.project1.controller.crawl;


import com.example.project1.entity.ProjectDaumNews;
import com.example.project1.service.VueDaumNewsCrawlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueCrawlController {

    @Autowired
    VueDaumNewsCrawlService service;

    @GetMapping("{category}")
    public List<ProjectDaumNews> getDaumNewsCategory(@PathVariable String category) {
        log.info("Crawling with getDaumNewsCategory(): " + category);

        service.daumNewsMainCrawler(category);

        return service.daumNewsFindAll();
    }
}