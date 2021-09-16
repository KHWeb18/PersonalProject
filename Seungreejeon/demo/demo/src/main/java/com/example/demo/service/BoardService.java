package com.example.demo.service;


import com.example.demo.entity.Board;

import java.util.List;

public interface BoardService {

    public void postBoard(Board board) throws Exception;

    public List<Board> fetchBoard() throws Exception;

}
