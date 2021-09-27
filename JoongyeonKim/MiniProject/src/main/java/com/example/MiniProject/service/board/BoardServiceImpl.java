package com.example.MiniProject.service.board;

import com.example.MiniProject.controller.board.BoardRequest;
import com.example.MiniProject.entity.board.Board;
import com.example.MiniProject.repository.board.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public void register(BoardRequest boardRequest) throws Exception {

        Board boardEntity = new Board(boardRequest.getEmail(),
                boardRequest.getTitle(), boardRequest.getContent());

        log.info("register Service: " + boardEntity);

        boardRepository.save(boardEntity);

    }
    @Override
    public List<Board> lists() throws Exception {
        return boardRepository.findAll();
    }

    /*
    @Override
    public BoardRequest read(Integer boardNo) throws Exception {
        return boardRepository.read(boardNo);
    }

    @Override
    public void remove(Integer boardNo) throws Exception {
        boardRepository.delete(boardNo);
    }

    @Override
    public void modify(BoardRequest boardRequest) throws Exception {
        boardRepository.update(boardRequest);
    }
     */
}
