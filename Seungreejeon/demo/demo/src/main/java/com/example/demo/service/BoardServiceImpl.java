package com.example.demo.service;


import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService{

    @Autowired
    BoardRepository boardRepository;

    @Override
    public List<Board> fetchBoard() throws Exception {
        return boardRepository.findAll();
    }

    @Override
    public void postBoard(Board board) throws Exception {

        boardRepository.save(board);
    }
}
