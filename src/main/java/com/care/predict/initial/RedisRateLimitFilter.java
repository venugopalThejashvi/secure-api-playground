package com.care.predict.initial;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.time.Duration;

@RequiredArgsConstructor
public class RedisRateLimitFilter implements Filter {
    private final StringRedisTemplate redisTemplate;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String key = httpRequest.getRemoteAddr() + " : " + httpRequest.getRequestURI();
        Long requests = redisTemplate.opsForValue().increment(key,1);
        if (requests == 1){
            long WINDOW_DURATION = 60;
            redisTemplate.expire(key, Duration.ofSeconds(WINDOW_DURATION));
        }

        int LIMIT = 5;
        if (requests > LIMIT){
            httpResponse.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
            return;
        }
        filterChain.doFilter(request, response);
    }
}
