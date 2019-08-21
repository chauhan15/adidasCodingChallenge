package com.adidas.newsletter.newsletterservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.adidas.newsletter.newsletterservice.configuration.FeignServiceConfiguration;
import com.adidas.newsletter.newsletterservice.entity.NewsletterSubscriptionParams;

@FeignClient(name = "newsletter-service", url = "localhost:8100", configuration = FeignServiceConfiguration.class)
public interface SubscriptionServiceProxy {
    @PostMapping("/subscriptions/create")
    public Long createSubscription(NewsletterSubscriptionParams newsletterSubscriptionParams);
}
