package com.example.market3.Controller1;

import com.example.market3.Controller1.MemberRequset.MemberRequest;
import com.example.market3.Controller1.MemberRequset.ProductBasketRequest;
import com.example.market3.Controller1.Session.UserInfo;
import com.example.market3.Entity.JpaMember;
import com.example.market3.Entity.JpaMemberBasket;
import com.example.market3.Service.JpaMemberService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/jpamemberManage")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class JpaMemberController {

    private HttpSession session;

    private UserInfo info;

    @Autowired
    JpaMemberService service;

    @PostMapping("/register")
    public  ResponseEntity<Void> jpaMemberRegister (
            @Validated @RequestBody MemberRequest memberRequest) throws  Exception {
            service.register(memberRequest);
        System.out.println(memberRequest.getBirthday());
            return new ResponseEntity<Void>(HttpStatus.OK);
    }



    @GetMapping("/lists")
    public ResponseEntity<List<JpaMember>> getListsMembers () throws Exception {
        log.info("getLists(): " + service.list());

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }
    @GetMapping("/{memberNo}")
    public ResponseEntity<JpaMember> read(@PathVariable("memberNo") Long memberNo) throws Exception {
        Optional<JpaMember> jpaMember = service.read(memberNo);
        JpaMember jpaMember1 = jpaMember.get();
        log.info("jpa" + jpaMember1);
        return new ResponseEntity<JpaMember>(jpaMember1, HttpStatus.OK);
    }
    @PostMapping("/ModifyMember/{memberNo}")
    public  ResponseEntity<Void> ModifyMember(@PathVariable("memberNo")Long memberNo, @Validated @RequestBody JpaMember jpaMember) throws  Exception {

        System.out.println("memberNo:"+memberNo);
        jpaMember.setMemberNo(memberNo);
        System.out.println(",userid:" +jpaMember.getUserid() +",password:"+jpaMember.getPassword()+",name:"+jpaMember.getName()+",email:"+jpaMember.getEmail()
        +",birthday:"+jpaMember.getBirthday()+",phoneNo:"+jpaMember.getPhoneNo()+",gender:"+jpaMember.getGender()+",address:"+jpaMember.getAddress()+",regDate"+jpaMember.getRegDate());


        service.ModifyMember(jpaMember);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }







    @PostMapping("/login")
    public ResponseEntity<UserInfo> jpaLogin(
            @RequestBody MemberRequest memberRequest, HttpServletRequest request) throws Exception {

        log.info("jpaLogin() - userId: " + memberRequest.getUserid() + ", password: " + memberRequest.getPassword());

        Boolean isSuccess = service.login(memberRequest);

        if (isSuccess) {
            log.info("Login Success");
            // 새션 할당 부분
            info = new UserInfo();
            info.setUserid(memberRequest.getUserid());
            log.info("Session Info:" + info );

            session = request.getSession();
            session.setAttribute("member", info);
        } else {
            log.info("Login Failure");
            info = null;
        }

       // return new ResponseEntity<UserInfo>(isSuccess, HttpStatus.OK);
        return  new ResponseEntity<UserInfo>(info, HttpStatus.OK);
    }

    @PostMapping("/needSession")
    public ResponseEntity<Boolean> postNeedSession(HttpServletRequest request) throws Exception {

        //UserInfo info = (UserInfo) session.getAttribute("member");
        Object obj = session.getAttribute("member");

        Boolean isLogin = false;

        if (obj != null) {
            log.info("Session Info: " + info);

            isLogin = service.checkUserIdValidation(info.getUserid());

            return new ResponseEntity<Boolean>(isLogin, HttpStatus.OK);
        }

        return new ResponseEntity<Boolean>(isLogin, HttpStatus.OK);
    }

    // 로그인 -> 게시물 작성
    //       -> 게시물 수정
    //       -> 팔로우
    //       -> 댓글 달기
    //       -> 삭제

    // 로그아웃 -> 게시물 작성
    // Spring 자체에서 처리가 불가능하므로
    // 로그아웃시 Vue쪽에 세션이 없다는 정보를 전달해줘야한다.
    // 그리고 사용자가 게시물 작성을 누르면 이 정보(참, 거짓)을 보고
    // 강제로 로그인 페이지로 보내거나 참(세션이 있음)이면 그대로 처리하는 방식을 취하도록 만들면 됨
    @PostMapping("/removeSession")
    public ResponseEntity<Boolean> removeSession(HttpServletRequest request) throws Exception {
        Boolean mustFalse = false;

        session.invalidate();

        return new ResponseEntity<Boolean>(mustFalse, HttpStatus.OK);
    }
    @DeleteMapping("{memberNo}")
    public ResponseEntity<Void> remove(@PathVariable Long memberNo) throws Exception{

        service.remove(memberNo);

        return new ResponseEntity<Void>( HttpStatus.OK);
    }

    @PostMapping("/addBasket/{memberNo}")
    public  ResponseEntity<Void> addBasket(@PathVariable("memberNo")Long memberNo, @Validated @RequestBody ProductBasketRequest productBasketRequest) throws  Exception {
        System.out.println(memberNo);
        productBasketRequest.setMemberNo(memberNo);
        service.addBasket(productBasketRequest);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/getBasketList/{memberNo}")
    public ResponseEntity<List<JpaMemberBasket>> getBasketList(@PathVariable("memberNo") Long memberNo) throws  Exception {


        service.getBasketList(memberNo);

        return new ResponseEntity<>(service.getBasketList(memberNo),HttpStatus.OK);
    }

    @PostMapping("/ModifyProductNum/{memberNo}")
    public ResponseEntity<Void> ModifyProductNum (@PathVariable("memberNo") Long memberNo, @Validated @RequestBody ProductBasketRequest productBasketRequest) throws  Exception {

        productBasketRequest.setMemberNo(memberNo);

        service.ModifyProductNum(productBasketRequest);

        return  new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/deleteProduct/{memberBasketNo}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("memberBasketNo")Long memberBasketNo) throws  Exception {

        service.deleteProduct(memberBasketNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/ModfiyEmail/{memberNo}")
    public ResponseEntity<Void> ModfiyEmail (@PathVariable("memberNo") Long memberNo, @Validated @RequestBody MemberRequest memberRequest) throws  Exception {

        String email = memberRequest.getEmail();

        service.ModfiyEmail(memberNo ,email);
        return new ResponseEntity<Void>(HttpStatus.OK);

    }
 @PostMapping("/ModfiyPhoneNo/{memberNo}")
    public  ResponseEntity<Void> ModfiyPhoneNo (@PathVariable("memberNo")Long memberNo, @Validated @RequestBody MemberRequest memberRequest) throws  Exception {
    int phoneNo  = memberRequest.getPhoneNo();

     System.out.println("memberNo:"+memberNo +",phoneNo:" +phoneNo);
     service.ModfiyPhoneNo(memberNo,phoneNo);
        return new ResponseEntity<Void>(HttpStatus.OK);
 }

 @PostMapping("/ModfiyAddress/{memberNo}")
    public ResponseEntity<Void> ModfiyAddress (@PathVariable("memberNo") Long memberNo, @Validated @RequestBody MemberRequest memberRequest ) throws  Exception {

        String address = memberRequest.getAddress();
        service.ModfiyAddress(memberNo, address);

     System.out.println("memberNo:"+memberNo +",address" +address);

        return new ResponseEntity<Void>(HttpStatus.OK);
 }

 @PostMapping("/checkingPassword")
    public ResponseEntity<Boolean> checkingPassWord(@Validated @RequestBody MemberRequest memberRequest) throws  Exception {


        Boolean isSuccess  = service.checkingPassWord(memberRequest);

        return  new ResponseEntity<>(isSuccess,HttpStatus.OK);
 }

 @PostMapping("/ModifyPassword/{memberNo}")
    public  ResponseEntity<Void> ModifyPassword (@PathVariable("memberNo")Long memberNo , @Validated @RequestBody MemberRequest memberRequest) throws  Exception {
     /*
      String userid = jpaMember.getUserid();
      String password = jpaMember.getPassword();
      String name = jpaMember.getName();
      String email = jpaMember.getEmail();
      int birthday = jpaMember.getBirthday();
      String  gender = jpaMember.getGender();
     String address = jpaMember.getAddress();
      int phoneNo = jpaMember.getPhoneNo();

     System.out.println("userid:" +userid +",password:" +password +",name:" +name +",email:" +email + ",birthday:" +birthday + ",gender" + gender + ",address:" + address
     + ",phoneNo:" + phoneNo  + ",memberNo" + memberNo);

      */
     String password = memberRequest.getPassword();

     System.out.println("memberNo:" +memberNo + ",password:" +password) ;

     service.ModifyPassword(memberNo,password);
        return new ResponseEntity<Void>(HttpStatus.OK);
 }

@PostMapping("/FindByMemberNo")
    public ResponseEntity<JpaMember> FindByMemberNo (@Validated @RequestBody MemberRequest memberRequest) throws  Exception {
        String userid = memberRequest.getUserid();
    System.out.println("userid: " + userid);
       //    Long memberNo = service.FindByMemberNo(memberRequest);
    try {
        Optional<JpaMember> jpaMember = service.FindByMemberNo(memberRequest);

        JpaMember jpaMember1 = jpaMember.get();
        return new ResponseEntity<>(jpaMember1,HttpStatus.OK);
    }catch (Exception e){
        JpaMember jpaMember2 = null;
        return new ResponseEntity<>(jpaMember2,HttpStatus.OK);
    }

}

@PostMapping("/IdMatchedBirthday")
    public ResponseEntity<Boolean> IdMatchedBirthday(@Validated @RequestBody MemberRequest memberRequest) throws  Exception {
   System.out.println(memberRequest.getMaybebirthday() + memberRequest.getUserid());
        Boolean result = service.IdMatchedBirthday(memberRequest);
        return new ResponseEntity<>(result,HttpStatus.OK);
}

@PostMapping("/FindById")
    public ResponseEntity<List> FindById(@Validated @RequestBody MemberRequest memberRequest) throws  Exception {

        String email = memberRequest.getEmail();
        List result = service.FindById(email);

        return  new ResponseEntity<>(result,HttpStatus.OK);
}

@DeleteMapping("/deleteMember/{memberNo}")
    public ResponseEntity<Void> deleteMember(@PathVariable("memberNo")Long memberNo) throws  Exception {

    service.deleteMember(memberNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
}






}
