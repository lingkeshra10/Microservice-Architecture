package com.lingkesh.microservice.EmailService.kafkaconsumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lingkesh.microservice.EmailService.grpc.LogsServiceGrpc;
import com.lingkesh.microservice.EmailService.management.EmailServiceManagement;
import com.lingkesh.microservice.EmailService.modal.SimpleEmailModal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceConsumer {

    @Value("${grpc.server.hostname}")
    private String grpcServerHostname;
    @Value("${grpc.server.port}")
    private int grpcServerPort;
    private final ObjectMapper objectMapper;
    private final EmailServiceManagement emailServiceManagement;

    private static final String consumeSimpleEmail = "${topic.simple.email}";
    private static final String consumeEmailWithAttachment = "${topic.attachment.email}";

    @Autowired(required = false)
    public EmailServiceConsumer(ObjectMapper objectMapper, EmailServiceManagement emailServiceManagement) {
        this.objectMapper = objectMapper;
        this.emailServiceManagement = emailServiceManagement;
    }

    @KafkaListener(topics = consumeSimpleEmail)
    public void consumeSimpleEmail(String message) throws JsonProcessingException {

        String remark = "0";
        SimpleEmailModal emailModal = objectMapper.readValue(message, SimpleEmailModal.class);

        String userId = emailModal.getUserId();
        String username = emailModal.getUsername();
        String email = emailModal.getEmail();
        String notificationType = emailModal.getEmailNotificationType();

        System.out.println("Username: "+ username);
        System.out.println("Email: "+ email);
        System.out.println("Email Notification Type: "+ notificationType);

        int result = emailServiceManagement.sendHtmlEmail(username, email, notificationType);

        //Need to send the log service for the record of the email result
        LogsServiceGrpc logsGrpc = new LogsServiceGrpc();
        logsGrpc.addServiceLogs(Long.parseLong(userId), result, remark, grpcServerHostname, grpcServerPort);

        //Added to the Email Queue if its failed
    }
}
