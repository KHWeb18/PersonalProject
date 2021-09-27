package com.pettalk.pettalkbackend.jwt;

import com.pettalk.pettalkbackend.entity.User;
import com.pettalk.pettalkbackend.security.AuthTokenProvider;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Slf4j
public class JwtAuthTokenProvider implements AuthTokenProvider<JwtAuthToken> {

    private final Key key;
    private final static long EXPIRED_TIME = 30;

    public JwtAuthTokenProvider(String secret) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    @Override
    public JwtAuthToken createAuthToken(User user, String role) {
        // 만료시간 설정
        Date expiredDate = Date.from(LocalDateTime.now().plusMinutes(EXPIRED_TIME).atZone(ZoneId.systemDefault()).toInstant());
        return new JwtAuthToken(user, role, expiredDate, key);
    }

    @Override
    public JwtAuthToken convertAuthToken(String token) {
        return new JwtAuthToken(token, key);
    }
}