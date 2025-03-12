package com.broilas.clean_architecture.core;

public interface EmailSenderUseCase {
    void sendEmail(String to, String subject, String body);
}
