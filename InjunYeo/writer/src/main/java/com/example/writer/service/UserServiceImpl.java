package com.example.writer.service;

import com.example.writer.entity.User;
import com.example.writer.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /*

     */
    @Override
    public boolean register(User user) throws Exception {

        if (userRepository.findByEmail(user.getEmail()) == null){
            log.info("tryRegister()! -- success");
            String encodePassword = passwordEncoder.encode(user.getPw());
            user.setPw(encodePassword);

            userRepository.save(user);
            return true;
        }else{
            log.info("tryRegister()! -- fail");
            return false;
        }


    }


    @Override
    public Integer login(User user) throws Exception {

        User maybeUser = userRepository.findByEmail(user.getEmail());

        if(maybeUser == null){
            log.info("login(): 이메일이 없습니다");
            return 1;
        }

        if(!passwordEncoder.matches(user.getPw(),maybeUser.getPw())){
            log.info("login() : 비밀번호가 다릅니다!");
            return 2;
        }

        return 3;

    }

    @Override
    public boolean checkUserIdValidation(String userEmail) throws Exception {
        User maybeUser = userRepository.findByEmail(userEmail);

        if(maybeUser ==null){
            log.info("검색결과 없음");
            return false;
        }

        return true;
    }


}
