package com.example.MiniProject.service;

import com.example.MiniProject.entity.DaumBlog;
import com.example.MiniProject.repository.DaumBlogRepository;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
@Slf4j
public class DaumBlogCrawlServiceImpl implements DaumBlogCrawlService {

    @Autowired
    DaumBlogRepository daumBlogRepository;

    private Document document;

    @Override
    public Document connectUrl(String url) {
        log.info("connectURL(): " + url);

        try {
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                            "AppleWebKit/537.36 (KHTML, like Gecko) " +
                            "Chrome/92.0.4515.107 " +
                            "Safari/537.36")
                    .execute();

            document = homepage.parse();
        } catch (Exception e) {
            log.info("Error in daumBlogMainCrawler");
        }

        return document;
    }

    @Override
    public List<DaumBlog> daumBlogFindAll() {
        log.info("daumBlogFindAll()");

        return daumBlogRepository.findAll();
    }

    @Override
    public void daumBlogMainCrawler(String category) {
        log.info("daumBlogMainCrawler()");

        document = connectUrl("https://news.daum.net/" + category);

        daumBlogRepository.deleteAll();

        daumBlogCrawling(document.select(
                "div.item_mainblog>div.cont_thumb>strong.tit_thumb>a"), category);
        daumBlogCrawling(document.select(
                "ul.list_mainblog>li>div.cont_thumb>strong.tit_thumb>a"), category);
        daumBlogCrawling(document.select(
                "strong.tit_mainblog>a"), category);
        daumBlogCrawling(document.select(
                "ul.list_ranking>li>span.cont_thumb>strong.tit_thumb>a"), category);
    }

    @Override
    public void daumBlogCrawling(Elements elements, String category) {
        log.info("daumBlogCrawling(): elements - " + elements + ", category - " + category);

        DaumBlog blog = null;

        for (int i = 0; i < elements.size(); i++) {
            blog = new DaumBlog();

            blog.setBlogNo(String.valueOf(daumBlogRepository.findAll().size() + 1));
            blog.setAddress(elements.get(i).attr("href"));
            blog.setCategory(category);
            blog.setTitle(elements.get(i).text());

            daumBlogRepository.save(blog);
        }
    }
}