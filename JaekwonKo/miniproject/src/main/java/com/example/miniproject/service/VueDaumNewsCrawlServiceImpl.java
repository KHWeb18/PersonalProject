package com.example.miniproject.service;


import com.example.miniproject.entity.ZowaNews;
import com.example.miniproject.repository.DaumNewsRepository;
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
public class VueDaumNewsCrawlServiceImpl implements com.example.miniproject.service.VueDaumNewsCrawlService {

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
    public List<ZowaNews> daumNewsFindAll() {
        log.info("daumNewsFindAll()");

        return daumNewsRepository.findAll();
    }

    /*
    @Override
    public void daumNewsHomeCrawling() {
        log.info("daumNewsHomeCrawling()");
        daumNewsHomeRepository.deleteAll();
        document = connectUrl("https://news.daum.net/");
        Elements total = document.select("strong.tit_thumb>a.link_txt");
        Elements image = document.select("div.item_issue>a.link_thumb>img.thumb_g");
        DaumNewsHome dnh = null;
        for (int i = 0; i < total.size(); i++) {
            dnh = new DaumNewsHome();
            dnh.setDaumNewsHomeNo(String.valueOf(i + 1));
            dnh.setTitle(total.get(i).text());
            dnh.setAddress(total.get(i).attr("href"));
            dnh.setImage(image.get(i).attr("src"));
            daumNewsHomeRepository.save(dnh);
        }
    }
     */

    @Override
    public void daumNewsMainCrawler(String category) {
        log.info("daumNewsMainCrawler()");

        document = connectUrl("https://search.daum.net/search?w=news&nil_search=btn&DA=NTB&enc=utf8&cluster=y&cluster_page=1&q=" + category);

        daumNewsRepository.deleteAll();

        daumNewsCrawling(document.select(
                "ul.list_news>li>div.wrap_cont>a"), category);
    }

    @Override
    public void daumNewsCrawling(Elements elements, String category) {
        log.info("daumNewsCrawling(): elements - " + elements + ", category - " + category);

        ZowaNews news = null;

        for (int i = 0; i < elements.size(); i++) {
            news = new ZowaNews();

            news.setNewsNo(String.valueOf(daumNewsRepository.findAll().size() + 1));
            news.setAddress(elements.get(i).attr("href"));
            news.setCategory(category);
            news.setTitle(elements.get(i).text());

            daumNewsRepository.save(news);
        }
    }
}
