package com.leekav.todo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private final long MAX_AGE_SECS = 3600;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //허락할 요청
        registry.addMapping("/**")
        //허락할 클라이언트 URL을 등록
         .allowedOrigins("http://localhost:3000")
        //허락할 요청 방식 설정
        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
        //허락할 헤더 설정
        .allowedHeaders("*")
        //인증 설정
        .allowCredentials(true)
        //최대 접속 시간
        .maxAge(MAX_AGE_SECS);
    }
}
