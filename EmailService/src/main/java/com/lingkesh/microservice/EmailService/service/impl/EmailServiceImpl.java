package com.lingkesh.microservice.EmailService.service.impl;

import com.lingkesh.microservice.EmailService.modal.EmailDetailsModal;
import com.lingkesh.microservice.EmailService.modal.ResponseModal;
import com.lingkesh.microservice.EmailService.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.io.File;

public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    private String sender;
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public int sendSimpleMail(EmailDetailsModal details) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(sender);
            message.setTo(details.getRecipient());
            message.setSubject(details.getSubject());
            message.setText(details.getMsgBody());

            emailSender.send(message);
            return ResponseModal.SUCCESS;
        } catch (MailException ex) {
            ex.printStackTrace();
            return ResponseModal.EXCEPTION_ERROR;
        }
    }

    @Override
    public int sendMailWithAttachment(EmailDetailsModal details) {
        // Creating a mime message
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {
            // Setting multipart as true for attachments to be send
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText(details.getMsgBody());
            mimeMessageHelper.setSubject(details.getSubject());

            // Adding the attachment
            FileSystemResource file = new FileSystemResource(new File(details.getAttachment()));

            mimeMessageHelper.addAttachment(file.getFilename(), file);

            // Sending the mail
            javaMailSender.send(mimeMessage);
            return ResponseModal.SUCCESS;
        } catch (MessagingException ex) {
            // Catch block to handle MessagingException
            ex.printStackTrace();
            // Display message when exception occurred
            return ResponseModal.EXCEPTION_ERROR;
        }
    }
}
