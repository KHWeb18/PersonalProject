package com.example.Mini.service.board;

import com.example.Mini.entity.board.Free;

import java.util.List;

public interface FreeBoardService {
    public void register(Free board) throws Exception;

    public List<Free> list() throws Exception;

    public Free read(Integer boardNo) throws Exception;

    public void remove(Integer boardNo) throws Exception;

    public void modify(Free board) throws Exception;

    public void findMemberNo(String content) throws Exception;
}