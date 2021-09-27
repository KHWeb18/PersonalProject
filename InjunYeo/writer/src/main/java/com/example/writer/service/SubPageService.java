package com.example.writer.service;

import com.example.writer.entity.MyPageBoard;

import java.util.List;

public interface SubPageService {


    public List<MyPageBoard> feedList(Long categoryNo) throws Exception;


}
