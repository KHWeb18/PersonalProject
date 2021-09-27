package com.example.market3.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@ToString
public class JpaOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long orderNo;


    @Column(length = 20, nullable = false)
    private String  buyUserName;
    @Column(length = 20, nullable = false)
    private String  userid;
    @Column(length = 100, nullable = false)
    private String  address;
    @Column(length = 100, nullable = false)
    private Integer  phoneNo;
    @Column(length = 100, nullable = false)
    private String  productName;
    @Column(length = 100, nullable = false)
    private Integer  productPrice;
    @Column(length = 100, nullable = false)
    private Integer  productNum;
    @Column(length = 20, nullable = false)
    private String  state ="입금확인중";
    @Column(length = 20, nullable = false)


    @CreationTimestamp
    private LocalDateTime createDate;

    @UpdateTimestamp
    private LocalDateTime lastModifiedDate;
}
