package com.example.market3.Rapository;

import com.example.market3.Entity.CustomerSoundComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface CustomerSoundServiceCommentRepository extends JpaRepository<CustomerSoundComment,Long> {

    @Transactional
    @Modifying
    @Query("UPDATE CustomerSoundComment CS set CS.comments = :comments where CS.customerSoundBoardNo = :customerSoundBoardNo")
    void commentModify(@Param("customerSoundBoardNo")Long customerSoundBoardNo ,@Param("comments") String comments);
}
