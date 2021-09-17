package com.example.market3.Rapository;

import com.example.market3.Entity.JpaMemberBasket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaProductBasketRepository extends JpaRepository<JpaMemberBasket,Long> {


    @Query("select BL from JpaMemberBasket BL where BL.memberNo = :memberNo")
    List<JpaMemberBasket> findBasketList(@Param("memberNo")Long memberNo);
}
