package com.example.miniProject.entity.jpa;

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
@Table(name = "member_auth")
public class MemberAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberAuthNo;

    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 64, nullable = false)
    private String auth;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    public MemberAuth(String auth) {
        this.auth = auth;
    }
}