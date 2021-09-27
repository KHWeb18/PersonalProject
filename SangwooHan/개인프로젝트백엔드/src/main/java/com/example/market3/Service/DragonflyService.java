package com.example.market3.Service;

import com.example.market3.Controller1.MemberRequset.DragonflyCommentRequest;
import com.example.market3.Entity.JpaDragonfly;
import com.example.market3.Entity.JpaDragonflyComment;

import java.util.List;
import java.util.Optional;

public interface DragonflyService {

    public  void register(JpaDragonfly jpaDragonfly)throws  Exception;

    public List<JpaDragonfly> getDragonList() throws  Exception;

    public Optional<JpaDragonfly> read(Long boardNo) throws  Exception;

    public void addcomments(DragonflyCommentRequest dragonflyCommentRequest) throws  Exception;

    public List<JpaDragonflyComment> getcomment(Long boardNo)throws  Exception;

    public  void addvuecount(Long boardNo) throws Exception;

    public  void ModifyComments(DragonflyCommentRequest dragonflyCommentRequest)throws  Exception;

    public void deleteComment(Long dragonflyCommentNo) throws Exception;

    public Optional<JpaDragonfly> searchtitle(DragonflyCommentRequest dragonflyCommentRequest) throws  Exception;

    public  void Modify(Long boardNo, String text) throws  Exception ;


}
