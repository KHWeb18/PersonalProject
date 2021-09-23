package com.pettalk.pettalkbackend.jwt;

import com.pettalk.pettalkbackend.entity.User;
import com.pettalk.pettalkbackend.exception.CustomJwtRuntimeException;
import com.pettalk.pettalkbackend.security.AuthToken;
import io.jsonwebtoken.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.security.Key;
import java.util.Date;
import java.util.Optional;

@Slf4j
public class JwtAuthToken implements AuthToken<Claims> {

    @Getter
    private final String token;
    private final Key key;

    private static final String AUTHORITIES_KEY = "role";

    JwtAuthToken(String token, Key key) {
        this.token = token;
        this.key = key;
    }

    JwtAuthToken(User user, String role, Date expiredDate, Key key) {
        this.key = key;
        this.token = createJwtAuthToken(user, role, expiredDate).get();
    }

    @Override
    public boolean validate() {
        return getData() != null;
    }

    @Override
    public Claims getData() {

        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        } catch (SecurityException e) {
            log.info("Invalid JWT signature.");
            throw new CustomJwtRuntimeException();
        } catch (MalformedJwtException e) {
            log.info("Invalid JWT token.");
            throw new CustomJwtRuntimeException();
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT token.");
            throw new CustomJwtRuntimeException();
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT token.");
            throw new CustomJwtRuntimeException();
        } catch (IllegalArgumentException e) {
            log.info("JWT token compact of handler are invalid.");
            throw new CustomJwtRuntimeException();
        }
    }

    private Optional<String> createJwtAuthToken(User user, String role, Date expiredDate) {

        String token = Jwts.builder()
                .setSubject("PETTALK") // 제목
                .claim(AUTHORITIES_KEY, role) // 권한
                .claim("id", user.getId()) // user id
                .claim("nickname", user.getNickname()) // user nickname
                .signWith(key, SignatureAlgorithm.HS256) // 토큰 알고리즘
                .setExpiration(expiredDate) // 만료시간
                .compact();

        return Optional.ofNullable(token);
    }
}