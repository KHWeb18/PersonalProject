package com.example.miniproject.service;

import com.example.miniproject.entity.ZowaNews;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

public interface VueDaumNewsCrawlService {

    public Document connectUrl(String url);
    public List<ZowaNews> daumNewsFindAll();
    public void daumNewsMainCrawler(String category);
    public void daumNewsCrawling(Elements elements, String category);
}