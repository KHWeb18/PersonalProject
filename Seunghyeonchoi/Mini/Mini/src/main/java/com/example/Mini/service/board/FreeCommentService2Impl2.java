package com.example.Mini.service.board;

import com.example.Mini.entity.board.Comment;
import com.example.Mini.repository.board.FreeCommentRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service는 여기서 register가 여러 방식으로 동작할 수 있음을 명시한다.
// 또한 Controller의 Autowired에 자동으로 연결되도록 서포트한다.
@Service
public class FreeCommentService2Impl2 implements FreeCommentService2 {

    @Autowired
    private FreeCommentRepository2 repository;


    @Override
    public List<Comment> list(int boardNo) throws Exception {
        return repository.list(boardNo);
    }

}