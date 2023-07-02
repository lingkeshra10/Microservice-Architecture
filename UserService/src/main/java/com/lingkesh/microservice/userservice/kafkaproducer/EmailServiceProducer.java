package com.lingkesh.microservice.userservice.kafkaproducer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lingkesh.microservice.userservice.kafkaproducer.modal.EmailModal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceProducer {

    @Value("${topic.name}")
    private String orderTopic;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public EmailServiceProducer(String orderTopic, KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.orderTopic = orderTopic;
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public String sendMessage(EmailModal emailModal) throws JsonProcessingException {
        String orderAsMessage = objectMapper.writeValueAsString(emailModal);
        kafkaTemplate.send(orderTopic, orderAsMessage);
        return "message sent";
    }

}
