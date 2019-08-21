package com.adidas.newsletter.subscribeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adidas.newsletter.subscribeservice.entity.NewsletterSubscriptionParams;

@Repository
public interface SubscriptionRepository extends JpaRepository<NewsletterSubscriptionParams, Long> {
}
