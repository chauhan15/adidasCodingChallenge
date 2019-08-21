package com.adidas.newsletter.newsletterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.adidas.newsletter.newsletterservice")
public class NewsletterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsletterServiceApplication.class, args);
	}

}
