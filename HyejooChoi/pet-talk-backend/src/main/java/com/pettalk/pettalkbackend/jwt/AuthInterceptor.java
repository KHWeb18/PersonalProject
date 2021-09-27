package com.pettalk.pettalkbackend.jwt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;

import com.pettalk.pettalkbackend.constants.ResultCode;
import com.pettalk.pettalkbackend.exception.CustomAuthenticationException;
import com.pettalk.pettalkbackend.exception.PetTalkException;
import com.pettalk.pettalkbackend.security.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final JwtAuthTokenProvider jwtAuthTokenProvider;
    private static final String AUTHORIZATION_HEADER = "Authorization";

    @Override
    public boolean preHandle(HttpServletRequest servletRequest, HttpServletResponse servletResponse, Object handler)
            throws Exception {

        Optional<String> token = resolveToken(servletRequest);

        if (token.isPresent()) {
            JwtAuthToken jwtAuthToken = jwtAuthTokenProvider.convertAuthToken(token.get());
            if (jwtAuthToken.validate() & Role.USER.getCode().equals(jwtAuthToken.getData().get("role"))) {
                return true;
            } else {
                throw new CustomAuthenticationException();
            }
        } else {
            throw new CustomAuthenticationException();
        }
    }

    private Optional<String> resolveToken(HttpServletRequest request) {
        String authToken = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(authToken) && authToken.startsWith("Bearer ")) {
            return Optional.of(authToken.substring(7));
        } else {
            return Optional.empty();
        }
    }
}