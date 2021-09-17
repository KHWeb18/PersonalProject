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
public class MyPageServiceImpl implements MyPageService{

    @Autowired
    private MyPageBoardRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    private Long userNo;
    /*
            if(categoryRepository.findAll() == null){
            Category emptyCategory  = new Category(null);
            categoryRepository.save(emptyCategory);
        }








        log.info("complete");
     */

    @Override
    public boolean register(MypageBoardRequset mypageBoardRequset) throws Exception{

        if(categoryRepository.findAll() == null){
            Category emptyCategory  = new Category(null);
            categoryRepository.save(emptyCategory);
        }

        log.info("category()!");

        String categoryName = mypageBoardRequset.getCategory();
        Category category = categoryRepository.findByName(categoryName);

        log.info("category:"+ category);


        if(repository.findAll() == null){
            MyPageBoard emptyBoard = new MyPageBoard(null,null,null);
            log.info("emptyBoard set()");
        }



        log.info("myPageBoardRegister() "+mypageBoardRequset.getTitle());
        log.info("tagName : "+mypageBoardRequset.getTag());

        userNo = userRepository.findByEmail(mypageBoardRequset.getWriter()).getUserNo();
        MyPageBoard regBoard = new MyPageBoard(mypageBoardRequset.getTitle(), mypageBoardRequset.getWriter(), mypageBoardRequset.getContent());
        regBoard.setUserNo(userNo);

        Tag tag = new Tag(mypageBoardRequset.getTag());
        regBoard.addTag(tag);

        if(category != null){
            category.addBoard(regBoard);
        }else{
            category = new Category(categoryName);
            category.addBoard(regBoard);
        }

        categoryRepository.save(category);

        log.info("board register()");

        return true;
    }

    @Override
    public List<MyPageBoard> myList(Long categoryNo ,Long userNo) throws Exception {

        return repository.findByCategoryNoAndUserNo(categoryNo,userNo);
    }

    @Override
    public Optional<MyPageBoard> read(Long boardNo) throws Exception {
        log.info("read() "+boardNo);


        return repository.findById(boardNo);
    }
}
