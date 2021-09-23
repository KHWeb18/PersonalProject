package com.pettalk.pettalkbackend.config;

import com.pettalk.pettalkbackend.jwt.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*").allowedOriginPatterns("*");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/signup")
                .excludePathPatterns("/board/list/**/**")
                .excludePathPatterns("/gallery/list/**/**")
                .excludePathPatterns("/board/popular")
                .excludePathPatterns("/gallery/popular");
    }
}