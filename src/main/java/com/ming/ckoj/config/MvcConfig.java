package com.ming.ckoj.config;

import com.ming.ckoj.utils.RefreshTokenInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //        token刷新
        registry.addInterceptor(new RefreshTokenInterceptor(stringRedisTemplate));
//        registry.addInterceptor(new LoginInterceptor(stringRedisTemplate))
//                .addPathPatterns("/**")
//                .excludePathPatterns(
//                        "/",
//                        "/error",
//                        "/favicon.ico",
//                        "/**/*.png",
//                        "/**/*.jpg",
//                        "/**/*.jpeg",
//                        "/**/*.gif",
//                        "/**/*.svg",
//                        "/**/*.css",
//                )
    }
}
