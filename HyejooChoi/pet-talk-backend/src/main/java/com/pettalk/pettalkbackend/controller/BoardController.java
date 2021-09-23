package com.pettalk.pettalkbackend.controller;

import com.pettalk.pettalkbackend.dto.BoardType;
import com.pettalk.pettalkbackend.dto.PetTalkResponse;
import com.pettalk.pettalkbackend.dto.board.BoardRequest;
import com.pettalk.pettalkbackend.entity.Board;
import com.pettalk.pettalkbackend.entity.Comment;
import com.pettalk.pettalkbackend.entity.Gallery;
import com.pettalk.pettalkbackend.service.BoardService;
import com.pettalk.pettalkbackend.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @Autowired
    private CommentService commentService;

    /**
     * 게시글 등록
     * @param boardRequest
     * @return
     */
    @PostMapping("/create")
    public PetTalkResponse<Board> create(@RequestBody BoardRequest boardRequest) {
        PetTalkResponse<Board> response = new PetTalkResponse<>();
        Board board = boardService.create(boardRequest);
        response.setData(board);
        return response;
    }

    /**
     * 게시글 수정
     * @param boardNo
     * @param boardRequest
     * @return
     */
    @PostMapping("/update/{boardNo}")
    public PetTalkResponse<Board> update(@PathVariable long boardNo, @RequestBody BoardRequest boardRequest) {
        PetTalkResponse<Board> response = new PetTalkResponse<>();
        Board board = boardService.update(boardNo, boardRequest);
        response.setData(board);
        return response;
    }

    /**
     * 게시글 조회
     * @param boardNo
     * @return
     */
    @GetMapping("/{boardNo}")
    public PetTalkResponse<Map<String, Object>> getBoard(@PathVariable long boardNo) {
        PetTalkResponse<Map<String, Object>> response = new PetTalkResponse<>();
        Board board = boardService.get(boardNo);
        List<Object[]> comment = commentService.getComment(BoardType.COMMUNITY, boardNo);
        Map<String, Object> map = new HashMap<>();
        map.put("board", board);
        map.put("comment", comment);
        response.setData(map);
        return response;
    }

    /**
     * 게시글 목록 조회 (페이징)
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list/{page}/{size}")
    public PetTalkResponse<Page<Object[]>> getBoardList(@PathVariable Integer page, @PathVariable Integer size) {
        PetTalkResponse<Page<Object[]>> response = new PetTalkResponse<>();
        Page<Object[]> boardList = boardService.getBoardList(PageRequest.of(page - 1, size, Sort.Direction.DESC, "id"));
        response.setData(boardList);
        return response;
    }

    /**
     * 인기 게시글 조회 (10개)
     * @return
     */
    @GetMapping("/popular")
    public PetTalkResponse<List<Board>> getPopularList() {
        PetTalkResponse<List<Board>> response = new PetTalkResponse<>();
        List<Board> boardList = boardService.getPopularList();
        response.setData(boardList);
        return response;
    }

    /**
     * 게시글 삭제
     * @param boardNo
     * @return
     */
    @DeleteMapping("/delete/{boardNo}")
    public PetTalkResponse<Boolean> delete(@PathVariable long boardNo) {
        PetTalkResponse<Boolean> response = new PetTalkResponse<>();
        Boolean boo = boardService.delete(boardNo);
        response.setData(boo);
        return response;
    }
}
