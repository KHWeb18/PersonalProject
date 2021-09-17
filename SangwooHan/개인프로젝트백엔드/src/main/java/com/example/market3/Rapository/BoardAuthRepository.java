package com.example.market3.Rapository;

import com.example.market3.Entity.JpaBoardComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface BoardAuthRepository extends JpaRepository<JpaBoardComment,Long> {

    @Query("SELECT cm  from JpaBoardComment cm where cm.boardNo = :boardNo  ")
    List<JpaBoardComment>finByComments(@Param("boardNo") Long boardNo);



}
