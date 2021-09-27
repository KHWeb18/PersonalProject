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
public class JpaProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long boardNo;


    @Column(length = 20, nullable = false)
    private String  productName;
    @Column(length = 20, nullable = false)
    private Integer productPrice;
    @Column(length = 2000, nullable = false)
    private String productDesc;
    @Column(length = 20, nullable = false)
    private String productType;
    @Column(length = 20, nullable = false)
    private Integer productStock;

    @Column(length = 2000, nullable = false)
    private Integer vuecount =0;
    @CreationTimestamp
    private LocalDateTime createDate;

    @UpdateTimestamp
    private LocalDateTime lastModifiedDate;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name= "board_no")
    private List<JpaProductComment> authList = new ArrayList<JpaProductComment>();
}
