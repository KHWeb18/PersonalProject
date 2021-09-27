package com.example.market3.Service;

import com.example.market3.Controller1.MemberRequset.BoardRequest;
import com.example.market3.Entity.JpaBoard;
import com.example.market3.Entity.JpaBoardComment;

import java.util.List;
import java.util.Optional;

public interface JpaBoardService {
    public void register(JpaBoard jpaBoard) throws  Exception;

    public List<JpaBoard> boardlist() throws Exception;

    public Optional<JpaBoard> read ( Long boardNo) throws  Exception;

    public void commanents(BoardRequest boardRequest) throws  Exception;

    public List<JpaBoardComment> finByComments(Long boardNo) throws Exception;

    public void CommunityModify (Long boardNo, String text ) throws  Exception;

    public void remove (Long boardNo) throws  Exception;

    public  void vuecountupdate (Long boardNo) throws  Exception;

    public  void commentModify (BoardRequest boardRequest) throws Exception;

    public  void removeComment(Long boardCommentNo) throws  Exception;

}
