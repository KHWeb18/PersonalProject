package com.example.FirstProject.service;

import com.example.FirstProject.entity.Recommend;
import com.example.FirstProject.request.RecommendDto;

import java.util.List;

public interface RecommendService {
    Recommend register(RecommendDto recommendDto) throws Exception;
    List<Recommend> list() throws Exception;
    Recommend read(Long boardNo) throws Exception;
    void modify(Recommend recommend, RecommendDto recommendDto) throws Exception;
    void remove(Recommend recommend) throws Exception;
    List<Recommend> userRead(String id) throws Exception;
}
