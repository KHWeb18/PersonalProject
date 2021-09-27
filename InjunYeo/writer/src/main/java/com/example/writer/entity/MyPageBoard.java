package com.example.writer.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name="MyPageBoard")
public class MyPageBoard {

    //더미보드를 0으로 시작해서 시작작


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="board_no")
    private Long boardNo;

    @Column(name="category_no")
    private Long categoryNo;

    @Column(name = "user_no")
    private Long userNo;

    @Column(length=64,nullable = false)
    private String title;



    @Column(length=64,nullable = false)
    private String writer;

    @Column(nullable = false)
    private String content;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="tag_no")
    private List<Tag> tags = new ArrayList<Tag>();



    public MyPageBoard(String title, String writer, String content){
        this.title = title;
        this.writer=writer;
        this.content=content;
    }

    public void addTag(Tag tag){
      tags.add(tag);
    }



    /*
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="tag_name")
    private List<Tag> userBoards = new ArrayList<Tag>();


     */
    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date upDate;



}
