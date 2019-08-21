package com.adidas.newsletter.subscribeservice.rabbitmq;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.adidas.newsletter.subscribeservice.entity.NewsletterSubscriptionParams;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SubscriptionProducer implements ISubscriptionProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Value("${subscription.rabbitmq.routing.key}")
    private String routingKey;

    @Value("${subscription.rabbitmq.exchange}")
    private String exchange;

    private static Logger log = LoggerFactory.getLogger(SubscriptionProducer.class.getName());

    @Override
    public void produce(NewsletterSubscriptionParams newsletterSubscriptionParams) {

        log.info("Going to send = " + newsletterSubscriptionParams + " to email service");

        try {
            MessageProperties properties = new MessageProperties();
            properties.setContentType(APPLICATION_JSON_VALUE);
            properties.setHeader("message-type", "subscription");
            Message message = null;
            message = new Message(objectMapper.writeValueAsBytes(newsletterSubscriptionParams), properties);
            amqpTemplate.convertAndSend(exchange, routingKey, message);
            log.info("Message sent = " + newsletterSubscriptionParams);
        } catch (AmqpException | JsonProcessingException e) {
            log.error("Message was not published " + e.getLocalizedMessage());
        }
    }
}
