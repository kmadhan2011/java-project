package com.example.Email_Service;

import com.example.Email_Service.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class EmailServiceApplication {

	@Autowired
	private EmailService emailService;


	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication.class, args);
	}


	@EventListener(ApplicationReadyEvent.class)
	public void sendEmail() {
        emailService.sendMail("akhil1561@gmail.com", "SpringDemo", "Spring Boot Email Service");
    }
}
