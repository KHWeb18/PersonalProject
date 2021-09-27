package com.example.market3.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@ToString
public class DaumNews {
    @Id// PRI key을 준다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto incre 역할
    private Long newsSeq;

    @Column(length = 20, nullable = false) // 20을 넘을수없다 // 널이 될수없다.
    private String newsNo;

    @Column(length = 20, nullable = false)
    private String category;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 2000, nullable = false)
    private String address;
 /*
    @Builder
    public DaumNews(String newsNo, String category, String title, String address) {
        this.newsNo = newsNo;
        this.address = address;
        this.category = category;
        this.title = title;
    }

  */

}
