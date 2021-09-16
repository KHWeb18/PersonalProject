package com.example.MiniProject.service.board;

import com.example.MiniProject.controller.board.BoardRequest;
import com.example.MiniProject.entity.board.Board;

import java.util.List;

public interface BoardService {

    public void register(BoardRequest board) throws Exception;

    List<Board> lists() throws Exception;

    //public BoardRequest read(Integer boardNo) throws Exception;

    //public void remove(Integer boardNo) throws Exception;

    //public void modify(BoardRequest boardRequest) throws Exception;
}
