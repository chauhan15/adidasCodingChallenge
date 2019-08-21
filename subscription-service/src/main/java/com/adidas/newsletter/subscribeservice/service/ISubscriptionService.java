package com.adidas.newsletter.subscribeservice.service;

import org.springframework.stereotype.Service;

import com.adidas.newsletter.subscribeservice.entity.NewsletterSubscriptionParams;

import java.util.List;
import java.util.Optional;

@Service
public interface ISubscriptionService {

    Long save(NewsletterSubscriptionParams newsletterSubscriptionParams);

    Optional<NewsletterSubscriptionParams> findOne(Long id);

    List<NewsletterSubscriptionParams> findAll();
}
