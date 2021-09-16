package com.example.project1.service;

import com.example.project1.entity.ProjectDaumNews;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

public interface VueDaumNewsCrawlService {
    public Document connectUrl(String url);
    public List<ProjectDaumNews> daumNewsFindAll();
    // daumNewsHomeFindAll();
    // public void daumNewsHomeCrawling();
    public void daumNewsMainCrawler(String category);
    public void daumNewsCrawling(Elements elements, String category);
    // pickOneDaumNewsCrawling(String newsNo);
}
