package com.example.Mini.service;

import com.example.Mini.entity.DaumNews;
import com.example.Mini.repository.DaumNewsRepository;
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
public class VueDaumNewsCrawlServiceImpl implements com.example.Mini.service.VueDaumNewsCrawlService {

    @Autowired
    DaumNewsRepository daumNewsRepository;

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
            log.info("Error in daumNewsMainCrawler");
        }

        return document;
    }

    @Override
    public List<DaumNews> daumNewsFindAll() {
        log.info("daumNewsFindAll()");

        return daumNewsRepository.findAll();
    }


    @Override
    public void daumNewsMainCrawler(String category) {
        log.info("daumNewsMainCrawler()");

        document = connectUrl("https://search.daum.net/search?nil_suggest=btn&w=tot&DA=SBC&q=%EA%B3%A0%EC%96%91%EC%9D%B4");

        daumNewsRepository.deleteAll();

        daumNewsCrawling(document.select(
                "ul.list_news>li>div.wrap_cont>a.tit_main"), category);
    }

    @Override
    public void daumNewsCrawling(Elements elements, String category) {
        log.info("daumNewsCrawling(): elements - " + elements + ", category - " + category);

        DaumNews news = null;

        for (int i = 0; i < elements.size(); i++) {
            news = new DaumNews();

            news.setNewsNo(String.valueOf(daumNewsRepository.findAll().size() + 1));
            news.setAddress(elements.get(i).attr("href"));
            news.setCategory(category);
            news.setTitle(elements.get(i).text());

            daumNewsRepository.save(news);
        }
    }
}