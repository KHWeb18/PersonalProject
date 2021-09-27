package com.example.market3.Service;

import com.example.market3.Controller1.MemberRequset.NoticeCommentRequest;
import com.example.market3.Entity.JpaBoard;
import com.example.market3.Entity.JpaNotice;
import com.example.market3.Entity.JpaNoticeComment;

import java.util.List;
import java.util.Optional;

public interface JpaNoticeService {

    public void register(JpaNotice jpaNotice) throws  Exception;

    public List<JpaNotice> Noticelist() throws Exception;

    public Optional<JpaNotice> read (Long boardNo)throws  Exception;

    public  void Noticecommanents (NoticeCommentRequest noticeCommentRequest) throws  Exception;

    public List<JpaNoticeComment> finByNoticeComments (Long boardNo) throws  Exception;

    public  void NoticeaddVueCount (Long boardNo) throws  Exception;

    public  void ModifyComment (NoticeCommentRequest noticeCommentRequest) throws  Exception;

    public  void deleteComment (Long noticeCommentNo) throws  Exception;

    public  void deleteNotice (Long boardNo) throws  Exception;

}
