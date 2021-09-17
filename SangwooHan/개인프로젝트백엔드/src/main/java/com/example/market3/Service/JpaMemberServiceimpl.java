package com.example.market3.Service;

import com.example.market3.Controller1.MemberRequset.MemberRequest;
import com.example.market3.Controller1.MemberRequset.ProductBasketRequest;
import com.example.market3.Entity.JpaMember;
import com.example.market3.Entity.JpaMemberBasket;
import com.example.market3.Rapository.JPAMemberRepository;
import com.example.market3.Rapository.JpaProductBasketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class JpaMemberServiceimpl implements JpaMemberService {

    @Autowired
    private JPAMemberRepository memberRepository;

    @Autowired
    private JpaProductBasketRepository jpaProductBasketRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(MemberRequest memberRequest) throws Exception {

        //비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
        memberRequest.setPassword(encodedPassword);


        // 엔티티에다가 리퀘스트멤버안에있는 Vue에서 받은 값들을 넣어주고있는 과정들이고
        // 조인컬럼에도 auth값을 넣어주고있다 .

        JpaMember jpaMemberEntity = new JpaMember(memberRequest.getUserid(), memberRequest.getPassword(), memberRequest.getName(), memberRequest.getEmail(), memberRequest.getBirthday(), memberRequest.getGender(),
                memberRequest.getAddress(), memberRequest.getPhoneNo());


        memberRepository.save(jpaMemberEntity);
    }

    @Override
    public List<JpaMember> list() throws Exception {
        return memberRepository.findAll();
    }

    @Override
    public Optional<JpaMember> read(Long memberNo) throws Exception {
        return memberRepository.findById(memberNo);
    }

    @Override
    public void modify(JpaMember jpaMember) throws Exception {
        String encodedPassword = passwordEncoder.encode(jpaMember.getPassword());
        jpaMember.setPassword(encodedPassword);
        memberRepository.save(jpaMember);
    }

    @Override
    public boolean login(MemberRequest memberRequest) throws Exception {


        Optional<JpaMember> maybeMember = memberRepository.findByUserId(memberRequest.getUserid());
        if (maybeMember == null) {
            log.info("login(): 그런 사람 없다.");
            return false;
        }

        JpaMember loginMember = maybeMember.get();

        if (!passwordEncoder.matches(memberRequest.getPassword(), loginMember.getPassword())) {
            log.info("login(): 비밀번호 잘못 입력하였습니다.");
            return false;
        }

        return true;
    }

    @Override
    public boolean checkUserIdValidation(String userid) throws Exception {
        Optional<JpaMember> maybeJpaMember = memberRepository.findByUserId(userid);

        if (maybeJpaMember == null) {
            log.info("login():  there is no id");

            return false;
        }


        return true;
    }

    @Override
    public void remove(Long memberNo) throws Exception {
        memberRepository.deleteById(memberNo);
    }

    @Override
    public void addBasket(ProductBasketRequest productBasketRequest) throws Exception {
        JpaMemberBasket jpaMemberBasket = new JpaMemberBasket(productBasketRequest.getMemberBasketNo(), productBasketRequest.getMemberNo(), productBasketRequest.getProductName(), productBasketRequest.getProductPrice(), productBasketRequest.getProductNum(), productBasketRequest.getRegDate());

        jpaProductBasketRepository.save(jpaMemberBasket);
    }

    @Override
    public List<JpaMemberBasket> getBasketList(Long memberNo) throws Exception {
        return jpaProductBasketRepository.findBasketList(memberNo);
    }

    @Override
    public void ModifyProductNum(ProductBasketRequest productBasketRequest) {

        JpaMemberBasket jpaMemberBasket = new JpaMemberBasket(productBasketRequest.getMemberBasketNo(), productBasketRequest.getMemberNo(), productBasketRequest.getProductName(), productBasketRequest.getProductPrice(), productBasketRequest.getProductNum(), productBasketRequest.getRegDate());
        jpaProductBasketRepository.save(jpaMemberBasket);
    }

    @Override
    public void deleteProduct(Long memberBasketNo) throws Exception {
        jpaProductBasketRepository.deleteById(memberBasketNo);
    }

    @Override
    public void ModfiyEmail(Long memberNo, String email) throws Exception {
        memberRepository.ModfiyEmail(memberNo, email);
    }

    @Override
    public void ModfiyPhoneNo(Long memberNo, int phoneNo) throws Exception {
        memberRepository.ModfiyPhoneNo(memberNo, phoneNo);
    }

    @Override
    public void ModfiyAddress(Long memberNo, String address) throws Exception {
        memberRepository.ModfiyAddress(memberNo, address);
    }

    @Override
    public Boolean checkingPassWord(MemberRequest memberRequest) throws Exception {
        Optional<JpaMember> maybeMember = memberRepository.findByUserId(memberRequest.getUserid());
        if (maybeMember == null) {
            log.info("login(): 그런 사람 없다.");
            return false;
        }

        JpaMember loginMember = maybeMember.get();

        if (!passwordEncoder.matches(memberRequest.getPassword(), loginMember.getPassword())) {
            log.info("login(): 비밀번호 잘못 입력하였습니다.");
            return false;
        }

        return true;
    }

    @Override
    public void ModifyPassword(Long memberNo, String Password) throws Exception {
        //  String encodedPassword = passwordEncoder.encode(jpaMember.getPassword());
        //jpaMember.setPassword(encodedPassword);
        // memberRepository.save(jpaMember);

        memberRepository.ModifyPassword(memberNo, Password);

    }



    @Override
    public Optional<JpaMember> FindByMemberNo(MemberRequest memberRequest) throws Exception {
        Optional<JpaMember> maybeMember = memberRepository.findByUserId(memberRequest.getUserid());

            return maybeMember ;
    }

    @Override
    public Boolean IdMatchedBirthday(MemberRequest memberRequest) throws Exception {

        Optional<JpaMember> maybeMember = memberRepository.findByUserId(memberRequest.getUserid());
           JpaMember loginmember = maybeMember.get();

        DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = loginmember.getBirthday();
        String UserBirthday = sdFormat.format(date1);


        DateFormat sdFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date2 = memberRequest.getMaybebirthday();
        String MaybeUserBirthday = sdFormat1.format(date2);

        System.out.println("DB:"+UserBirthday +"Vue:"+MaybeUserBirthday);

        if(UserBirthday.equals(MaybeUserBirthday)){

            return true;
        }

        return false;
    }

    @Override
    public List FindById(String email) throws Exception {
        return memberRepository.FindById(email);
    }

    @Override
    public void deleteMember(Long memberNo) throws Exception {
        memberRepository.deleteById(memberNo);
    }

    @Override
    public void ModifyMember(JpaMember jpaMember) throws Exception {

        String encodedPassword = passwordEncoder.encode(jpaMember.getPassword());
        jpaMember.setPassword(encodedPassword);
        memberRepository.save(jpaMember);
    }
}