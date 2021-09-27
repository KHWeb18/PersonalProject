package com.example.Mini.entity.board;

import com.example.Mini.entity.member.MemberAuth;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class Notice {
    private int boardNo;
    // th:field로 맵핑됨
    private String title;
    private String content;
    private String writer;
    private String nickname;
    private Date regDate;
}
