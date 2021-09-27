package com.example.market3.Controller1.MemberRequset;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Slf4j
@NoArgsConstructor
public class MemberRequest {

        private String userid;
        private String password;
        private String name;
        private String email;
        private Date birthday;
        private String  gender;
        private String address;
        private int phoneNo;
        private Long memberNo;
        private Date regDate;
        private Date maybebirthday;
}
