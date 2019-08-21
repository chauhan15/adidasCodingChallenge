package com.adidas.newsletter.newsletterservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adidas.newsletter.newsletterservice.entity.NewsletterSubscriptionParams;
import com.adidas.newsletter.newsletterservice.proxy.SubscriptionServiceProxy;

import javax.validation.Valid;

@RestController
public class NewsletterController {

    private static Logger log = LoggerFactory.getLogger(NewsletterController.class.getName());

    @Autowired
    private SubscriptionServiceProxy subscriptionServiceProxy;

    @PostMapping("/newsletter-subscription")
    public Long submitSubscription(@Valid @RequestBody NewsletterSubscriptionParams newsletterSubscriptionParams) {
        log.info("Received subscription " + newsletterSubscriptionParams + " to be created");
        return subscriptionServiceProxy.createSubscription(newsletterSubscriptionParams);
    }
}
