package com.adidas.newsletter.subscribeservice.rabbitmq;

import com.adidas.newsletter.subscribeservice.entity.NewsletterSubscriptionParams;

public interface ISubscriptionProducer {
    void produce(NewsletterSubscriptionParams newsletterSubscriptionParams);
}
