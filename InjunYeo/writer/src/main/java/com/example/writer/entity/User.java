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
@Table(name="user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_no")
    private Long userNo;

    @Column(length=64,nullable = false)
    private String email;

    @Column(length=255,nullable = false)
    private String pw;

    @Column(length = 64,nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="user_no")
    private List<MyPageBoard> userBoards = new ArrayList<MyPageBoard>();

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date upDate;


}
