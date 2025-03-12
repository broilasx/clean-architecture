package com.broilas.clean_architecture.controllers;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.broilas.clean_architecture.application.EmailSenderUseCaseImpl;
import com.broilas.clean_architecture.core.exceptions.EmailServiceException;

@RestController
@RequestMapping("/api/email")
public class EmailSenderController {
    private final EmailSenderUseCaseImpl emailSenderUseCaseImpl;

    @Autowired
    public EmailSenderController(EmailSenderUseCaseImpl emailSenderUseCaseImpl) {
        this.emailSenderUseCaseImpl = emailSenderUseCaseImpl;
    }

    @PostMapping()
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
        try {
            this.emailSenderUseCaseImpl.sendEmail(emailRequest.to(), emailRequest.subject(), emailRequest.body());
            return ResponseEntity.ok("Email sent successfully");
        } catch (EmailServiceException e) {
            return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body("Failed to send email");
        }
    }
}
