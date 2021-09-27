package com.example.Mini.service.board;

import com.example.Mini.entity.board.Free;
import com.example.Mini.repository.board.FreeBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class FreeBoardServiceImpl implements FreeBoardService {

    @Autowired
    private HttpSession session;

    @Autowired
    private FreeBoardRepository repository;

    @Override
    public void register(Free board) throws Exception {
        repository.create(board);
    }

    @Override
    public List<Free> list() throws Exception {
        return repository.list();
    }

    @Override
    public Free read(Integer boardNo) throws Exception {
        session.setAttribute("selectBoardNo", boardNo); // comment 컨트롤러에서 쓰려고 작성
        return repository.read(boardNo);
    }

    @Override
    public void remove(Integer boardNo) throws Exception {
        repository.delete(boardNo);
    }

    @Override
    public void modify(Free board) throws Exception {
        repository.update(board);
    }

    @Override
    public void findMemberNo(String content) throws Exception {
        repository.select(content);
    }
}