package com.pettalk.pettalkbackend.service;

import com.pettalk.pettalkbackend.dto.board.BoardRequest;
import com.pettalk.pettalkbackend.entity.Board;
import com.pettalk.pettalkbackend.entity.User;
import com.pettalk.pettalkbackend.repository.BoardRepository;
import com.pettalk.pettalkbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;

    @Autowired
    UserRepository userRepository;

    /**
     * 게시글 등록
     * @param boardRequest
     */
    public Board create(BoardRequest boardRequest) {
        User user = userRepository.findById(boardRequest.writer).orElse(null);

        Board board = Board.builder()
                        .title(boardRequest.title)
                        .content(boardRequest.content)
                        .writer(boardRequest.writer)
                        .writerName(user.getNickname())
                        .count(1)
                        .build();
        boardRepository.save(board);
        return board;
    }

    /**
     * 게시글 수정
     * @param boardNo 게시글 번호
     * @param boardRequest
     * @return
     */
    public Board update(long boardNo, BoardRequest boardRequest) {
        Board board = boardRepository.findById(boardNo).orElse(null);
        board.setTitle(boardRequest.title);
        board.setContent(boardRequest.content);
        boardRepository.save(board);
        return board;
    }

    /**
     * 게시글 조회
     * @param boardNo
     * @return
     */
    public Board get(long boardNo) {
        Board board = boardRepository.findById(boardNo).orElse(null);
        User user = userRepository.findById(board.getWriter()).orElse(null);
        board.setWriterName(user.getNickname());

        if (board != null) {
            board.setCount(board.getCount() + 1);
            boardRepository.save(board);
        }
        return board;
    }

    /**
     * 게시글 목록 조회 (페이징)
     * @return
     */
    public Page<Object[]> getBoardList(PageRequest pageRequest) {
        return boardRepository.findAllCustom(pageRequest);
    }

    /**
     * 인기 게시글 목록 조회 (10개)
     * @return
     */
    public List<Board> getPopularList() {
        return boardRepository.findPopularList();
    }

    /**
     * 게시글 삭제
     * @param boardNo
     * @return
     */
    public Boolean delete(long boardNo) {
        Board board = boardRepository.findById(boardNo).orElse(null);
        boardRepository.delete(board);
        return true;
    }
}
