package com.lingkesh.microservice.EmailService.kafkaconsumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lingkesh.microservice.EmailService.management.EmailServiceManagement;
import com.lingkesh.microservice.EmailService.modal.EmailAttachmentModal;
import com.lingkesh.microservice.EmailService.modal.SimpleEmailModal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceConsumer {

    private static final String consumeSimpleEmail = "${topic.simple.email}";
    private static final String consumeEmailWithAttachment = "${topic.attachment.email}";

    private final ObjectMapper objectMapper;

    @Autowired
    public EmailServiceConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = consumeSimpleEmail)
    public void consumeSimpleEmail(String message) throws JsonProcessingException {

        SimpleEmailModal emailModal = objectMapper.readValue(message, SimpleEmailModal.class);

        String username = emailModal.getUsername();
        String email = emailModal.getEmail();
        String notificationType = emailModal.getEmailNotificationType();

        System.out.println("Username: "+ username);
        System.out.println("Email: "+ email);
        System.out.println("Email Notification Type: "+ notificationType);

        //Send to email management for sending the email
        EmailServiceManagement management = new EmailServiceManagement();
        int result = management.sendEmail(username, email, notificationType);

        System.out.println("Result: "+ result);

        //Need to send the log service for the record of the email result
    }

    @KafkaListener(topics = consumeEmailWithAttachment)
    public void consumeEmailWithAttachment(String message) throws JsonProcessingException {

        EmailAttachmentModal emailModal = objectMapper.readValue(message, EmailAttachmentModal.class);

        String username = emailModal.getUsername();
        String email = emailModal.getEmail();
        String notificationType = emailModal.getEmailNotificationType();
        String emailAttachment = emailModal.getAttachment();

        System.out.println("Username: "+ username);
        System.out.println("Email: "+ email);
        System.out.println("Email Notification Type: "+ notificationType);
        System.out.println("Email Attachment: "+ emailAttachment);

        //Send to email management for sending the email
        EmailServiceManagement management = new EmailServiceManagement();

        int result = management.sendEmail(username, email, notificationType);

        System.out.println("Result: "+ result);

        //Need to send the log service for the record of the email result
    }

}
