package com.example.market3.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@ToString
public class JpaNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long boardNo;


    @Column(length = 20, nullable = false)
    private String  title;
    @Column(length = 20, nullable = false)
    private String id;
    @Column(length = 2000, nullable = false)
    private String text;
    @Column(length = 20, nullable = false)
    private String type1;

    @Column(length = 2000, nullable = false)
    private Integer vuecount =0;
    @CreationTimestamp
    private LocalDateTime createDate;

    @UpdateTimestamp
    private LocalDateTime lastModifiedDate;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name= "board_no")
    private List<JpaNoticeComment> authList = new ArrayList<JpaNoticeComment>();
}
