package com.broilas.clean_architecture.adapters;

public interface EmailSenderGateway {
    void sendEmail(String to, String subject, String body);
    
} 
