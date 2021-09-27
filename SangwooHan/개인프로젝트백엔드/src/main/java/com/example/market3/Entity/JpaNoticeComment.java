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
@Table(name = "jpa_notice_comment")
public class JpaNoticeComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeCommentNo;

    @Column(name = "board_no")
    private Long boardNo;

    @Column(length = 64, nullable = false)
    private String ui;

    @Column(length = 64, nullable = false)
    private String comments;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date upDate;

    public JpaNoticeComment(Long noticeCommentNo,Long boardNo, String ui, String comments, Date regDate) {
        this.ui = ui;
        this.comments = comments;
        this.boardNo = boardNo;
        this.noticeCommentNo = noticeCommentNo;
        this.regDate = regDate;

    }
}
