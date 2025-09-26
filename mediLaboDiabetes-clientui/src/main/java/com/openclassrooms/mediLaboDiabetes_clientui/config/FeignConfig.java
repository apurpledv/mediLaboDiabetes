package com.openclassrooms.mediLaboDiabetes_clientui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

/**
 * FeignConfig gives Feign a basic access to the Gateway microservices (secured via Spring Security using a simple authentication - user & password)
 */
@Configuration
public class FeignConfig {
    @Bean
    public BasicAuthRequestInterceptor mBasicAuthRequestInterceptor() {
        return  new BasicAuthRequestInterceptor("user", "user");
    }
}
