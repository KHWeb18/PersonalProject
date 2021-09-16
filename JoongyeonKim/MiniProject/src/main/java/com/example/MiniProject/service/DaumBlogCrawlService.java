package com.example.MiniProject.service;


import com.example.MiniProject.entity.DaumBlog;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

public interface DaumBlogCrawlService {
    public Document connectUrl(String url);
    public List<DaumBlog> daumBlogFindAll();
    // daumNewsHomeFindAll();
    // public void daumNewsHomeCrawling();
    public void daumBlogMainCrawler(String category);
    public void daumBlogCrawling(Elements elements, String category);
    // pickOneDaumNewsCrawling(String newsNo);
}
