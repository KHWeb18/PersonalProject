package com.example.writer.controller;


import com.example.writer.entity.MyPageBoard;
import com.example.writer.repository.CategoryRepository;
import com.example.writer.service.SubPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/sub")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class SubPageController {

    private Long categoryNo;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    SubPageService service;

    @PostMapping("/feed-board-list")
    public ResponseEntity<List<MyPageBoard>> postSubPageFeedBoardLists(@RequestBody CategoryRequest categoryRequest) throws Exception{

        log.info("getSubPageFeedBoardLists()");
        log.info("email()"+ categoryRequest.getEmail());
        log.info("category()" + categoryRequest.getCategory());

        categoryNo = categoryRepository.findByName(categoryRequest.getCategory()).getCategoryNo();
        log.info("categoryNo():"+categoryNo);


        return new ResponseEntity<>(service.feedList(categoryNo), HttpStatus.OK);
    }
}
