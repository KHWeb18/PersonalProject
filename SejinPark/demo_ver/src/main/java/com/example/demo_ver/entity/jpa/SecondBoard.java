package com.example.demo_ver.entity.jpa;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class SecondBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "board_No")
    private Long boardNo;

    @Column(length = 20, nullable = false)
    private String writer;

    @Column(length = 20, nullable = false)
    private String title;

    @Column(length = 20, nullable = false)
    private String content;

    public SecondBoard(String writer, String title,String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

}