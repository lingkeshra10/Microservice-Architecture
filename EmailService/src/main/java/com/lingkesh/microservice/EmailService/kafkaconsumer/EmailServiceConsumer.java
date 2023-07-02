package com.lingkesh.microservice.EmailService.kafkaconsumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lingkesh.microservice.EmailService.modal.EmailModal;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceConsumer {

    private static final String orderTopic = "${topic.name}";

    private final ObjectMapper objectMapper;

    @Autowired
    public EmailServiceConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = orderTopic)
    public void consumeMessage(String message) throws JsonProcessingException {
        System.out.println("message consumed {}"+ message);

        EmailModal emailModal = objectMapper.readValue(message, EmailModal.class);

        System.out.println("Username: "+ emailModal.getUsername());
        System.out.println("Email: "+ emailModal.getEmail());
        System.out.println("Email Notification Type: "+ emailModal.getEmailNotificationType());

        //Send to email management for sending the email
    }

}
