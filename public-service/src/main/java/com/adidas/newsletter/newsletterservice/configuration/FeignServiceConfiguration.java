package com.adidas.newsletter.newsletterservice.configuration;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignServiceConfiguration {

    @Value("${subscriber.username}")
    private String subscriberUsername;

    @Value("${subscriber.password}")
    private String subscriberPassword;

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {

        return new BasicAuthRequestInterceptor(subscriberUsername, subscriberPassword);
    }
}
