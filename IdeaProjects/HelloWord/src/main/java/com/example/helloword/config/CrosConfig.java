package com.example.helloword.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrosConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 允许跨域访问的路径
                .allowedOriginPatterns("*") // 允许跨域访问的源
                .allowedMethods("POST", "GET", "PUT", "DELETE", "OPTIONS") // 允许请求方法
                .maxAge(1808989) // 预测间隔时间
                .allowedHeaders("*")  // 允许头部设置
                .allowCredentials(true); // 是否发送 cookie
    }
}
