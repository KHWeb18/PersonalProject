package com.pettalk.pettalkbackend.service;

import com.pettalk.pettalkbackend.constants.HttpStatus;
import com.pettalk.pettalkbackend.constants.PetTalkError;
import com.pettalk.pettalkbackend.constants.ResultCode;
import com.pettalk.pettalkbackend.dto.user.LoginRequest;
import com.pettalk.pettalkbackend.dto.user.LoginResponse;
import com.pettalk.pettalkbackend.dto.user.SignUpRequest;
import com.pettalk.pettalkbackend.dto.user.UpdateUserRequest;
import com.pettalk.pettalkbackend.entity.AuthToken;
import com.pettalk.pettalkbackend.entity.User;
import com.pettalk.pettalkbackend.exception.PetTalkException;
import com.pettalk.pettalkbackend.jwt.JwtAuthToken;
import com.pettalk.pettalkbackend.jwt.JwtAuthTokenProvider;
import com.pettalk.pettalkbackend.repository.AuthTokenRepository;
import com.pettalk.pettalkbackend.repository.UserRepository;
import com.pettalk.pettalkbackend.security.Role;
import jdk.nashorn.internal.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private JwtAuthTokenProvider jwtAuthTokenProvider;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthTokenRepository authTokenRepository;

    /**
     * 로그인
     * @param loginRequest
     * @return
     */
    public LoginResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByUserId(loginRequest.getLoginId());
        if (user == null || !user.getPassword().equals(loginRequest.getPassword())) {
            throw new PetTalkException("사용자를 찾을 수 없습니다.", ResultCode.CANNOT_FIND, null);
        }
        if (!user.getPassword().equals(loginRequest.getPassword())) {
            throw new PetTalkException("아이디 혹은 비밀번호가 일치하지 않습니다.", ResultCode.CANNOT_FIND, null);
        }
        JwtAuthToken jwtAuthToken = jwtAuthTokenProvider.createAuthToken(user, Role.USER.getCode());
        UUID uuid = UUID.randomUUID();
        String refreshToken = uuid.toString();

        AuthToken authToken = AuthToken.builder()
                    .userId(user.getId())
                    .token(refreshToken)
                    .expiredAt(LocalDateTime.now().plusHours(2))
                    .build();

        authTokenRepository.save(authToken);

        return new LoginResponse(jwtAuthToken.getToken(), refreshToken);
    }

    /**
     * 회원 가입
     * @param signUpRequest
     * @return
     */
    public User signUp(SignUpRequest signUpRequest) {

        // ID 중복 체크
        if (userRepository.existsByUserId(signUpRequest.getUserId())) {
            throw new PetTalkException("중복된 아이디입니다.", ResultCode.INTERNAL_SERVER_ERROR, null);
        }

        // 유저 생성
        User user = User.builder()
                .userId(signUpRequest.getUserId())
                .password(signUpRequest.getPassword())
                .email(signUpRequest.getEmail())
                .nickname(signUpRequest.getNickname())
                .build();

        return userRepository.save(user);
    }

    /**
     * 회원 정보 조회
     * @param userNo
     * @return
     */
    public User getUser(long userNo) {
        // 존재하는 사용자인지 체크
        if (!userRepository.existsById(userNo)) {
            throw new PetTalkException("사용자가 존재하지 않습니다", ResultCode.CANNOT_FIND, null);
        }
        return userRepository.findById(userNo).orElse(null);
    }

    /**
     * 회원 정보 수정
     * @param user 회원의 기존 정보
     * @param updateUserRequest 수정할 회원 정보
     */
    public User updateUser(User user, UpdateUserRequest updateUserRequest) {
        user.setPassword(updateUserRequest.getPassword());
        user.setNickname(updateUserRequest.getNickname());
        user.setEmail(updateUserRequest.getEmail());
        return userRepository.save(user);
    }
}
