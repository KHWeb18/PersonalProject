package com.example.springbackend.repository;

import com.example.springbackend.entity.Reply;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ReplyRepository extends CrudRepository<Reply, Long> {

    @Query("select r from Reply r where r.comment_no = :commentNo")
    public List<Reply> getRepliesOfComment(Long commentNo);

    @Query("select r from Reply r where r.replyNo = :replyNo")
    public List<Reply> findByReplyNo(Long replyNo);

    @Transactional
    @Modifying
    @Query(value = "delete from Reply where comment_no =:comment_no")
    void deleteByCommentNo(@Param("comment_no")Long comment_no);
}
