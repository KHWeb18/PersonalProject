package com.example.market3.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString
@Entity

public class JpaMemberBasket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberBasketNo;

    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 64, nullable = false)
    private  String productName;

    @Column(length = 64, nullable = false)
    private  Integer productPrice;

    @Column(length = 64, nullable = false)
    private  Integer productNum;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date upDate;

   public JpaMemberBasket(Long memberBasketNo,Long memberNo, String productName , Integer productPrice, Integer productNum,Date regDate){

       this.memberNo = memberNo;
       this.productName =productName;
       this.productPrice = productPrice;
       this.productNum = productNum;
       this.memberBasketNo =memberBasketNo;
       this.regDate = regDate;

   }

}
