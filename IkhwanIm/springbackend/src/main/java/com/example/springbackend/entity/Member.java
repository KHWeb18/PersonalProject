package com.example.springbackend.entity;

import com.example.springbackend.controller.request.MemberRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 64, nullable = false)
    private String member_id;

    @Column(length = 400, nullable = false)
    private String member_pw;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @CreationTimestamp
    private Date regDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @UpdateTimestamp
    private Date updDate;

    public Member(String member_id, String member_pw, String email, String name) {
        this.member_id = member_id;
        this.member_pw = member_pw;
        this.email = email;
        this.name = name;
    }

    public void updateMember(MemberRequest memberRequest) {
        this.member_id = memberRequest.getMember_id();
        this.member_pw = memberRequest.getMember_pw();
        this.email = memberRequest.getEmail();
        this.name = memberRequest.getName();
    }
}
