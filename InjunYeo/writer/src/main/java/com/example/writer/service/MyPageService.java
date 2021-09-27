package com.example.writer.service;

import com.example.writer.controller.MypageBoardRequset;
import com.example.writer.entity.MyPageBoard;

import java.util.List;
import java.util.Optional;

public interface MyPageService {

    public boolean register(MypageBoardRequset mypageBoardRequset) throws Exception;

    public List<MyPageBoard> myList(Long categoryNo ,Long userNo) throws Exception;

    public Optional<MyPageBoard> read(Long boardNo) throws Exception;
}
