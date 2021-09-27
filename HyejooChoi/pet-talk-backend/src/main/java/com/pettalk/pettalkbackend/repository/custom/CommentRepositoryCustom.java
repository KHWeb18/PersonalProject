package com.pettalk.pettalkbackend.repository.custom;

import com.pettalk.pettalkbackend.dto.BoardType;

import java.util.List;

public interface CommentRepositoryCustom {
    List<Object[]> findByBoardTypeAndBoardNoCustom(BoardType boardType, long boardNo);
}
