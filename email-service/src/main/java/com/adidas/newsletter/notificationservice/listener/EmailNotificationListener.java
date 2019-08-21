package com.adidas.newsletter.notificationservice.listener;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adidas.newsletter.notificationservice.dto.NewsletterSubscriptionParams;
import com.adidas.newsletter.notificationservice.service.IEmailNotificationService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class EmailNotificationListener {

    @Autowired
    private IEmailNotificationService emailNotificationService;

    private static ObjectMapper objectMapper = new ObjectMapper();

    private static Logger log = LoggerFactory.getLogger(EmailNotificationListener.class.getName());

    @RabbitListener(
        id = "subscription-listener",
        bindings = @QueueBinding(
            value = @Queue(value = "subscription.queue", durable = "true"),
            exchange = @Exchange(value = "subscription"),
            key = "subscription.routing.key"
        )
    )
    public void receiveMessage(Message message) {

        try {
            log.info("Received subscription message: " + message.toString());
            NewsletterSubscriptionParams newsletterSubscriptionParams = objectMapper.readValue(message.getBody(), NewsletterSubscriptionParams.class);

            emailNotificationService.sendSimpleMessage(newsletterSubscriptionParams);
            newsletterSubscriptionParams.setNewsletterSent(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
