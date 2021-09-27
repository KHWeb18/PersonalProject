package com.example.project1.entity.jpa;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name="pr_member")
public class PrMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 64, nullable = false)
    private String userId;

    @Column(length = 64, nullable = false)
    private String password;

    @Column(length = 64, nullable = false)
    private String name;

    @Column(length = 64, nullable = false)
    private String phoneNo;

    @Column(length = 64, nullable = false)
    private String email;

    @Column(length = 64, nullable = false)
    private String address;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    /* Join Column 파트 */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_no")
    private List<PrMemberAuth> authList = new ArrayList<PrMemberAuth>();

    public PrMember(String userId, String password, String name, String phoneNo, String email, String address) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
        this.address = address;

    }

    public void addAuth(PrMemberAuth auth) {
        authList.add(auth);
    }

    public void clearAuthList () {
        authList.clear();
    }
}