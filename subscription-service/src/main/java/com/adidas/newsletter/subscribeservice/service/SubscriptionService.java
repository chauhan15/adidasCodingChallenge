package com.adidas.newsletter.subscribeservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adidas.newsletter.subscribeservice.entity.NewsletterSubscriptionParams;
import com.adidas.newsletter.subscribeservice.repository.SubscriptionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService implements ISubscriptionService {

    private static Logger log = LoggerFactory.getLogger(SubscriptionService.class.getName());

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public Long save(NewsletterSubscriptionParams newsletterSubscriptionParams) {
        log.info("Saving subscription = " + newsletterSubscriptionParams);
        subscriptionRepository.save(newsletterSubscriptionParams);
        log.info("Subscription = " + newsletterSubscriptionParams + " saved successfully");
        return newsletterSubscriptionParams.getId();
    }

    @Override
    public Optional<NewsletterSubscriptionParams> findOne(Long id) {
        return subscriptionRepository.findById(id);
    }

    @Override
    public List<NewsletterSubscriptionParams> findAll() {
        return subscriptionRepository.findAll();
    }
}
