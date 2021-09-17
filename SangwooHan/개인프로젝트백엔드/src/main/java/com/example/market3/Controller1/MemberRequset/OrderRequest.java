package com.example.market3.Controller1.MemberRequset;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class OrderRequest {

    private String shipping;
    private Integer quantity;
    private String userid;
}
