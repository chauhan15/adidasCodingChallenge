package com.adidas.newsletter.subscribeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adidas.newsletter.subscribeservice.entity.NewsletterSubscriptionParams;
import com.adidas.newsletter.subscribeservice.rabbitmq.ISubscriptionProducer;
import com.adidas.newsletter.subscribeservice.service.ISubscriptionService;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private static Logger log = LoggerFactory.getLogger(SubscriptionController.class.getName());

    @Autowired
    private ISubscriptionService subscriptionService;

    @Autowired
    private ISubscriptionProducer subscriptionProducer;

    @PostMapping("/create")
    public Long createSubscription(@RequestBody NewsletterSubscriptionParams newsletterSubscriptionParams) {

        log.info("Received subscription = " + newsletterSubscriptionParams);
        subscriptionService.save(newsletterSubscriptionParams);
        subscriptionProducer.produce(newsletterSubscriptionParams);

        return newsletterSubscriptionParams.getId();
    }
}
