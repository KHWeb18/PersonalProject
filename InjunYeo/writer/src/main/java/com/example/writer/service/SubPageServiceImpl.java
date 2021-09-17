package com.example.writer.service;

import com.example.writer.controller.MypageBoardRequset;
import com.example.writer.entity.Category;
import com.example.writer.entity.MyPageBoard;
import com.example.writer.entity.Tag;
import com.example.writer.repository.CategoryRepository;
import com.example.writer.repository.MyPageBoardRepository;
import com.example.writer.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SubPageServiceImpl implements SubPageService{

    @Autowired
    private MyPageBoardRepository repository;

    private Long userNo;
    /*
            if(categoryRepository.findAll() == null){
            Category emptyCategory  = new Category(null);
            categoryRepository.save(emptyCategory);
        }








        log.info("complete");
     */



    @Override
    public List<MyPageBoard> feedList(Long categoryNo) throws Exception {
        log.info("feedList()"+categoryNo);

        return repository.findByCategoryNo(categoryNo);
    }

}
