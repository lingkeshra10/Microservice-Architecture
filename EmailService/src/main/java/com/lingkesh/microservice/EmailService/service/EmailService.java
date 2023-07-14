package com.lingkesh.microservice.EmailService.service;

import com.lingkesh.microservice.EmailService.modal.EmailDetailsModal;

public interface EmailService {

    // Method
    // To send a simple email
    int sendSimpleMail(EmailDetailsModal details);

    // Method
    // To send an email with attachment
    int sendMailWithAttachment(EmailDetailsModal details);
}
