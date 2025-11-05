package com.care.predict.initial;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
/**
 * Configures and registers the RedisRateLimitFilter for specific API endpoints.
 * */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<RedisRateLimitFilter> rateLimitFilter(StringRedisTemplate redisTemplate) {
        FilterRegistrationBean<RedisRateLimitFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new RedisRateLimitFilter(redisTemplate));
        registrationBean.addUrlPatterns("/auth/health");
        return registrationBean;
    }
}