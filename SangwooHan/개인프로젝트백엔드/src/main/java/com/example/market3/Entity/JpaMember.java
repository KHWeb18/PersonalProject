package com.example.market3.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@ToString
public class JpaMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Long memberNo;
    @Column(length = 64,nullable = false)
    private String userid;
    @Column(length = 256,nullable = false)
    private String password;
    @Column(length = 64, nullable = false)
    private String name;
    @Column(length = 64, nullable = false)
    private String email;
    @Column(length = 64, nullable = false)
    private Date birthday;
    @Column(length = 64, nullable = false)
    private String  gender;
    @Column(length = 100, nullable = false)
    private String address;
    @Column(length = 20, nullable = false)
    private int phoneNo;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private LocalDateTime lastModifiedDate;


    @OneToMany(cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_no")
    private List<JpaMemberBasket> authList = new ArrayList<JpaMemberBasket>();


    /*
    @OneToMany
    @JoinColumn(name = "member_no")
    private List<JpaBoard> memberList = new ArrayList<JpaBoard>();

     */


       public JpaMember(String userid , String password , String name, String email,
                        Date birthday, String  gender, String address, int phoneNo) {
           this.userid = userid;
           this.password = password;
           this.name = name;
           this.email = email;
           this.birthday = birthday;
           this.gender = gender;
           this.address = address;
           this.phoneNo = phoneNo;

       }



    public void addAuth(JpaMemberBasket auth) {
           authList.add(auth);
       }
       public void  clearAuthList(){
           authList.clear();
       }
}


