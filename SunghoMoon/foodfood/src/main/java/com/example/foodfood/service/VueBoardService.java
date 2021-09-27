package com.example.foodfood.service;

import com.example.foodfood.entity.Board;

import java.util.List;

public interface VueBoardService {
    public void register(Board board) throws Exception;

    public List<Board> list() throws Exception;

    public Board read(Integer boardNo) throws Exception;

    public void remove(Integer boardNo) throws Exception;

    public void modify(Board board) throws Exception;
}