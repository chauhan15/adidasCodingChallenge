package com.adidas.newsletter.notificationservice.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.adidas.newsletter.notificationservice.dto.NewsletterSubscriptionParams;

@Service
public class EmailNotificationService implements IEmailNotificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String senderMail;

    private static Logger log = LoggerFactory.getLogger(EmailNotificationService.class.getName());

    @Override
    public void sendSimpleMessage(NewsletterSubscriptionParams newsletterSubscriptionParams) {

        log.info("Going to send newsletter email to " + newsletterSubscriptionParams.getEmail());

        try {

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom(senderMail);
            helper.setTo(newsletterSubscriptionParams.getEmail());
            helper.setSubject("Email for " + newsletterSubscriptionParams.getFirstName());
            helper.setText("As you were born on " + newsletterSubscriptionParams.getDateOfBirth() + "\n" +
                    "here you have newsletter for campaign with id " + newsletterSubscriptionParams.getCampaignId());

            javaMailSender.send(message);

            log.info("Mail sent to " + newsletterSubscriptionParams.getEmail() + " successfully");

            //TODO connect to DB and set subscription as finished

        } catch (MessagingException e) {
            log.error("Something went wrong while sending email " + e.getLocalizedMessage());
        }
    }
}
