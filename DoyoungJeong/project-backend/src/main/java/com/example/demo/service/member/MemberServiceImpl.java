package com.example.demo.service.member;

import com.example.demo.controller.concert.request.ConcertDeleteRequest;
import com.example.demo.controller.concert.request.ConcertRequest;
import com.example.demo.controller.member.request.MemberRequest;
import com.example.demo.controller.member.response.MemberResponse;
import com.example.demo.entity.board.Board;
import com.example.demo.entity.member.*;
import com.example.demo.repository.artistAuth.ConcertRequestRepository;
import com.example.demo.repository.board.BoardReplyRepository;
import com.example.demo.repository.concert.ConcertRepository;
import com.example.demo.repository.board.BoardRepository;
import com.example.demo.repository.member.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberIdentityRepository memberIdentityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private LikedConcertRepository likedConcertRepository;

    @Autowired
    private ConcertRepository concertRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardReplyRepository boardReplyRepository;

    @Autowired
    private MemberTasteRepository memberTasteRepository;

    @Autowired
    private ConcertRequestRepository concertRequestRepository;

    @Autowired
    private BookedConcertRepository bookedConcertRepository;

    @Override
    @Transactional
    public boolean register(MemberRequest memberRequest) throws Exception {

        if(!memberRepository.findByMemberId(memberRequest.getId()).isEmpty()) {
            log.info("ID that Already Exists!");
            return false;

        } else {

            String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
            memberRequest.setPassword(encodedPassword);

            String location = memberRequest.getLocation().replaceAll("\\[", "").replaceAll("\\]","").
                    replaceAll("\"", "");

            MemberIdentity memberIdentity = new MemberIdentity(memberRequest.getIdentity());
            Member member = new Member(memberRequest.getId(), memberRequest.getPassword(), memberRequest.getName(),
                    location, memberRequest.getBirthDay(), memberRequest.getPhoneNo());

//            LikedConcert likedConcert = new LikedConcert();
//            likedConcert.setConcertNo(new Long(0));
//            likedConcert.setConcertName("default");
//            likedConcert.setConcertArtist("default");
//            likedConcert.setConcertVenue("default");
//            likedConcert.setConcertPrice("default");
//            likedConcert.setConcertDate("default");
//            likedConcert.setConcertInfo("default");

//            String[] defaultOne = new String[0];
//            String[] defaultTwo = new String[0];

            //MemberTaste memberTaste = new MemberTaste("default", "default", "default", "default");

//            Board board = new Board("default", "default"); ????????? ????????? ????????? ????????? ??????
//            board.setId("default");
//            BoardReply boardReply = new BoardReply("default", "default");
//            board.addBoardReply(boardReply);

            //BookedConcert bookedConcert = new BookedConcert(null, null, null, null); ??????????????? ?????????

            member.addIdentity(memberIdentity);
            //member.addLikedConcert(likedConcert);
            //member.addMemberTaste(memberTaste);
            //member.addBoardContent(board);
            //member.addBookedConcert(bookedConcert);
            memberRepository.save(member);

            log.info("New ID has registered!");
            return true;
        }
    }

    @Override
    @Transactional
    public Member login(MemberRequest memberRequest) throws Exception {

        try {
            Optional<Member> requestedId = memberRepository.findByMemberId(memberRequest.getId()); //null????????? ???????????? ?????????

            log.info("confirmed ID: " + requestedId.get().getId() + ", confirmed PW: " + requestedId.get().getPassword() +
                    ", memberRequestPW: " + memberRequest.getPassword());

            if (passwordEncoder.matches(memberRequest.getPassword(), requestedId.get().getPassword())) {
                log.info("Valid ID");

                Member confirmedMember = requestedId.get();
                return confirmedMember;
            } else {
                log.info("Wrong Password has been input!");
                Member noMember = new Member();
                noMember.setId("no");

                return noMember;
            }

        } catch (NoSuchElementException noSuchElementException) {
            log.info("Not Existed ID!");

        } finally {
            ;
        }
        Member noMember = new Member();
        noMember.setId("no");

        return noMember;
    }

    @Override
    public boolean checkSessionValidation(String memberId) throws Exception {

        return true;
    }

    @Override
    public List<Member> getList() throws Exception {
        return memberRepository.getList();
    }

    @Override
    public Member read(Long memberNo) throws Exception {

        Member member = memberRepository.findByMemberNo(memberNo).get();

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String formatDate = sdf.format(member.getRegDate());
//        log.info("formatDate: " + formatDate);

        //Date newDate = sdf.parse(member.getRegDate().getDate() + " " + member.getRegDate().getTime()); //ParseException: Unparseable date: "4 1630730129000"
        //log.info("newDate: " + newDate);\

        //Date date = sdf.parse("2018.09.09"); sdf??? ?????? ????????? ???????????? ?????????
        //log.info("date: " + date);

        return member;
    }

    @Override
    public void delete(Long memberNo) throws Exception {
        memberIdentityRepository.delete(memberNo); //?????? ?????? ???????????? ?????? ????????? ????????? ?????? ???????????? ?????????

        Long deleteNo;
        List<LikedConcert> likedConcertList = likedConcertRepository.findByMemberNo(memberNo);//????????? ??? ?????? ???????????? ???????????? ?????? concert?????? number_of_likes??? 1??? ????????? ????????????

        for(int i=0; i<likedConcertList.size(); i++) {

            deleteNo = likedConcertList.get(i).getConcertNo();

            concertRepository.minusNumberOfLikes(deleteNo);
        }

        Integer numOfVisitorsForDelete;
        List<BookedConcert> bookedConcertList = bookedConcertRepository.findByMemberNo(memberNo);

        for(int i=0; i<bookedConcertList.size(); i++) {

            numOfVisitorsForDelete = bookedConcertList.get(i).getNumOfVisitors();
            deleteNo = bookedConcertList.get(i).getConcertNo();

            concertRepository.plusVenueCapacity(numOfVisitorsForDelete, deleteNo);
        }

        String id = memberRepository.findByMemberNo(memberNo).get().getId(); //????????? ????????? ????????? ????????? id ?????????.
        boardRepository.makeIdAsWithdrawn(id);
        boardReplyRepository.makeIdAsWithdrawn(id);

        concertRequestRepository.makeIdAsWithdrawn(memberNo); //????????? ????????? ????????? ?????? ????????? id ?????????.

        likedConcertRepository.delete(memberNo);

        memberTasteRepository.delete(memberNo);
        bookedConcertRepository.delete(memberNo);
        memberRepository.delete(memberNo);
    }

    @Override
    public MemberResponse modify(MemberRequest memberRequest) throws Exception { //?????? ?????????????????? ?????? ?????????????????? ????????? ??????????????? ???
        String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
        memberRequest.setPassword(encodedPassword);

        Long memberNo = new Long(memberRequest.getMemberNo());

        String location = memberRequest.getLocation().replaceAll("\\[", "").replaceAll("\\]","").
                replaceAll("\"", "");

        memberIdentityRepository.modify(memberRequest.getIdentity(), memberNo);

        memberRepository.modify(memberRequest.getId(), memberRequest.getPassword(), memberRequest.getName(),
                location, memberRequest.getBirthDay(), memberRequest.getPhoneNo(), memberNo);

        //?????? ????????? ??????, ????????? ????????? ?????? ?????? ??????

        MemberResponse memberResponse = new MemberResponse(new Long(memberRequest.getMemberNo()), memberRequest.getId(), memberRequest.getIdentity());

        return memberResponse;
    }

    @Override
    public void addLiked(ConcertRequest concertRequest) throws Exception {

        LikedConcert likedConcert = new LikedConcert(concertRequest.getConcertNo(), concertRequest.getConcertName(),
                concertRequest.getConcertArtist(), concertRequest.getConcertVenue(), concertRequest.getConcertPrice(), concertRequest.getConcertDate(),
                concertRequest.getConcertInfo());

        likedConcert.setMemberNo(concertRequest.getMemberNo());

        if(isNotAlreadyLiked(likedConcert.getMemberNo(), likedConcert.getConcertNo())) {
            likedConcertRepository.save(likedConcert);
            concertRepository.plusNumberOfLikes(new Long(concertRequest.getConcertNo()));
        } else {
            log.info("isAlreadyLiked!");
        }
    }

    @Override
    public boolean isNotAlreadyLiked(Long memberNo, Long concertNo) {
        return likedConcertRepository.findByMemberNoAndConcertNo(memberNo, concertNo).isEmpty();
    }

    @Override
    public void deleteLiked(ConcertDeleteRequest concertDeleteRequest) throws Exception {
        likedConcertRepository.deleteByConcertNo(new Long(concertDeleteRequest.getConcertNo()), new Long(concertDeleteRequest.getMemberNo()));
        concertRepository.minusNumberOfLikes(new Long(concertDeleteRequest.getConcertNo())); //concert???????????? number_of_likes??? 1??? ??????
    }

    @Override
    public boolean checkPassword(MemberRequest memberRequest) throws Exception {

        Optional<Member> tmpMember = memberRepository.findByMemberId(memberRequest.getId());
        boolean ismatchedPassword = false;

        if(!tmpMember.isEmpty()) {

            ismatchedPassword = passwordEncoder.matches(memberRequest.getPassword(), tmpMember.get().getPassword()); //???????????? ????????? ?????????
            return ismatchedPassword;
        }
        return ismatchedPassword;
    }
}
