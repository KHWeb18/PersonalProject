package com.example.MiniProject.entity.funding;

import com.example.MiniProject.controller.funding.FundingRequest;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "funding")
public class Funding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funding_no", nullable = false)
    private Long fundingNo;

    @Column(length = 300, nullable = false)
    private String category;

    @Column(length = 300, nullable = false)
    private String writer;

    @Column(length = 300, nullable = false)
    private String title;

    @Column(nullable = false)
    private String image;

    @Column(length = 80000, nullable = false)
    private String content;

    @Column(nullable = false)
    private String summary;

    @Column(nullable = false)
    private String fundingEnd;

    @Column(nullable = false)
    private Long endMoney;

    @Column(nullable = false)
    private Long nowMoney;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    // Join Column 파트
    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JoinColumn(name = "member_no")
    //private List<MemberAuth> authList = new ArrayList<MemberAuth>();

    public Funding(String category, String writer, String title, String image, String summary,
                        String content, String fundingEnd, Long endMoney, Long nowMoney) {
        this.category = category;
        this.writer = writer;
        this.title = title;
        this.image = image;
        this.content = content;
        this.summary = summary;
        this.fundingEnd = fundingEnd;
        this.endMoney = endMoney;
        this.nowMoney = nowMoney;
    }


    public void updateFunding(FundingRequest fundingRequest) {
        this.category = fundingRequest.getCategory();
        this.writer = fundingRequest.getWriter();
        this.title = fundingRequest.getTitle();
        this.image = fundingRequest.getImage();
        this.content = fundingRequest.getContent();
        this.summary = fundingRequest.getSummary();
        this.fundingEnd = fundingRequest.getFundingEnd();
        this.endMoney = fundingRequest.getEndMoney();
        this.nowMoney = fundingRequest.getNowMoney();
    }

    public void payFundingRequest(FundingRequest fundingRequest) {
        this.nowMoney = fundingRequest.getNowMoney();
    }


}
