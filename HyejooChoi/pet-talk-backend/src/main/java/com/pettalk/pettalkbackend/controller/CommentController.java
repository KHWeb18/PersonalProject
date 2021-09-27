package com.pettalk.pettalkbackend.controller;

import com.pettalk.pettalkbackend.dto.BoardType;
import com.pettalk.pettalkbackend.dto.PetTalkResponse;
import com.pettalk.pettalkbackend.dto.board.BoardRequest;
import com.pettalk.pettalkbackend.dto.comment.CommentModifyRequest;
import com.pettalk.pettalkbackend.dto.comment.CommentRequest;
import com.pettalk.pettalkbackend.entity.Board;
import com.pettalk.pettalkbackend.entity.Comment;
import com.pettalk.pettalkbackend.service.CommentService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 댓글 등록
     * @param boardType 게시판 종류
     * @param boardNo 게시글 번호
     * @param commentRequest 댓글 Request (내용, 작성자)
     * @return
     */
    @PostMapping("/create/{boardType}/{boardNo}")
    public PetTalkResponse<Comment> create(@PathVariable BoardType boardType,
                                           @PathVariable Long boardNo,
                                           @RequestBody CommentRequest commentRequest) {
        PetTalkResponse<Comment> response = new PetTalkResponse<>();
        Comment comment = commentService.create(boardType, boardNo, commentRequest);
        response.setData(comment);
        return response;
    }

    @DeleteMapping("/delete/{commentId}")
    public PetTalkResponse<Boolean> delete(@PathVariable long commentId) {
        PetTalkResponse<Boolean> response = new PetTalkResponse<>();
        Boolean boo = commentService.delete(commentId);
        response.setData(boo);
        return response;
    }

    @PostMapping("/modify/{commentId}")
    public PetTalkResponse<Comment> modify(@PathVariable long commentId, @RequestBody CommentModifyRequest commentModifyRequest) {
        PetTalkResponse<Comment> response = new PetTalkResponse<>();
        Comment comment = commentService.modify(commentId, commentModifyRequest);
        response.setData(comment);
        return response;
    }
}
