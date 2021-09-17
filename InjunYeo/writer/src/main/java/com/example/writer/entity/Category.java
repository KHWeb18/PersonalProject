package com.example.writer.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name="Category")
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_no")
    private Long categoryNo;

    @Column(length=64,nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="category_no")
    private List<MyPageBoard> boards = new ArrayList<MyPageBoard>();

    public void addBoard(MyPageBoard board){
        boards.add(board);
    }

    public Category(String name){
        this.name = name;
    }


}
