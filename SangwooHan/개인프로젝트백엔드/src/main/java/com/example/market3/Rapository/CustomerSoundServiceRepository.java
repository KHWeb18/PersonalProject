package com.example.market3.Rapository;

import com.example.market3.Entity.CustomerSound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface CustomerSoundServiceRepository extends JpaRepository<CustomerSound,Long> {

    @Transactional
    @Modifying
    @Query("UPDATE CustomerSound CS set CS.vuecount = CS.vuecount+1 where CS.boardNo = :boardNo")
    void addvuecount(@Param("boardNo")Long boardNo);
}
