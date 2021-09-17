package com.example.market3.Service;

import com.example.market3.Controller1.MemberRequset.NoticeCommentRequest;
import com.example.market3.Entity.JpaBoard;
import com.example.market3.Entity.JpaNotice;
import com.example.market3.Entity.JpaNoticeComment;
import com.example.market3.Rapository.JpaNoticeRepository;
import com.example.market3.Rapository.NoticeCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JpaNoticeServiceimpl  implements JpaNoticeService{

    @Autowired
    JpaNoticeRepository jpaNoticeRepository;

    @Autowired
    NoticeCommentRepository noticeCommentRepository;

    @Override
    public void register(JpaNotice jpaNotice) throws Exception {
        jpaNoticeRepository.save(jpaNotice);
    }

    @Override
    public List<JpaNotice> Noticelist() throws Exception {
        return jpaNoticeRepository.findAll();
    }

    @Override
    public Optional<JpaNotice> read(Long boardNo) throws Exception {
        return jpaNoticeRepository.findById(boardNo);
    }

    @Override
    public void Noticecommanents(NoticeCommentRequest noticeCommentRequest) throws Exception {

        JpaNoticeComment jpaNoticeComment = new JpaNoticeComment(noticeCommentRequest.getNoticeCommentNo(),noticeCommentRequest.getBoardNo(),noticeCommentRequest.getUi(), noticeCommentRequest.getComments(),noticeCommentRequest.getRegDate());

        noticeCommentRepository.save(jpaNoticeComment);
    }

    @Override
    public List<JpaNoticeComment> finByNoticeComments(Long boardNo) throws Exception {
        return noticeCommentRepository.finByNoticeComments(boardNo);
    }

    @Override
    public void NoticeaddVueCount(Long boardNo) throws Exception {
        jpaNoticeRepository.NoticeaddVueCount(boardNo);
    }

    @Override
    public void ModifyComment(NoticeCommentRequest noticeCommentRequest) throws Exception {
        JpaNoticeComment jpaNoticeComment = new JpaNoticeComment(noticeCommentRequest.getNoticeCommentNo(),noticeCommentRequest.getBoardNo(),noticeCommentRequest.getUi(), noticeCommentRequest.getComments(),noticeCommentRequest.getRegDate());

        noticeCommentRepository.save(jpaNoticeComment);
    }

    @Override
    public void deleteComment(Long noticeCommentNo) throws Exception {

        noticeCommentRepository.deleteById(noticeCommentNo);
    }

    @Override
    public void deleteNotice(Long boardNo) throws Exception {

        jpaNoticeRepository.deleteById(boardNo);
    }
}
