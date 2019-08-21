package com.adidas.newsletter.notificationservice.service;

import org.springframework.stereotype.Service;

import com.adidas.newsletter.notificationservice.dto.NewsletterSubscriptionParams;

@Service
public interface IEmailNotificationService {
    void sendSimpleMessage(NewsletterSubscriptionParams newsletterSubscriptionParams);
}
