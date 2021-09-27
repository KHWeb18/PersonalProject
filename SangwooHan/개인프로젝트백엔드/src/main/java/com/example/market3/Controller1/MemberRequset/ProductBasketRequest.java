package com.example.market3.Controller1.MemberRequset;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Data
@Slf4j
@NoArgsConstructor
public class ProductBasketRequest {

    private Long memberNo;
    private Long memberBasketNo;
    private String productName;
    private Integer productPrice;
    private Integer productNum;
    private Date regDate;
}
