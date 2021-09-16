package com.example.springbackend.service;

import com.example.springbackend.controller.request.BoardRequest;
import com.example.springbackend.entity.Board;
import com.example.springbackend.entity.Comment;
import com.example.springbackend.repository.BoardRepository;
import com.example.springbackend.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void register(BoardRequest boardRequest) throws Exception {
        Board boardEntity = new Board(boardRequest.getBoardNo(), boardRequest.getWriter(), boardRequest.getTitle(),
                boardRequest.getLink(), boardRequest.getContent(), boardRequest.getRegDate(), boardRequest.getUpdDate());

        boardRepository.save(boardEntity);
    }

    @Override
    public List<Board> boardFindAll() throws Exception {

        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

    @Override
    public List<Board> findByBoardNo(Long boardNo) throws Exception {

        return boardRepository.findByBoardNo(boardNo);
    }

    @Override
    public void modify(Board board, BoardRequest boardRequest) throws Exception {
        board.updateBoard(boardRequest);
        boardRepository.save(board);
    }

    @Override
    public void delete(Long boardNo) throws Exception {
        commentRepository.deleteByBoardNo(boardNo);
        boardRepository.deleteById(boardNo);
    }
}
