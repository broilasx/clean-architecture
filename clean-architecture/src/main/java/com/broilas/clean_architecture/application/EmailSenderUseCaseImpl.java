package com.broilas.clean_architecture.application;

import org.springframework.beans.factory.annotation.Autowired;

public class EmailSenderUseCaseImpl implements EmailSenderUseCase {

    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public EmailSenderUseCaseImpl(EmailSenderGateway emailSenderGateway) {
        this.emailSenderGateway = emailSenderGateway;
    }
    
    @Override
    public void sendEmail(String to, String subject, String body) {
        System.out.println("Sending email to " + to + " with subject " + subject + " and body " + body);
    }

}
