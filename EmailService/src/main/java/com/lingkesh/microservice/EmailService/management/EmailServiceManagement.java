package com.lingkesh.microservice.EmailService.management;

import com.lingkesh.microservice.EmailService.modal.EmailDetailsModal;
import com.lingkesh.microservice.EmailService.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailServiceManagement {

    @Autowired
    EmailService emailService;

    public int sendEmail(String username, String userEmail, String emailNotificationType){

        String subject;
        String emailContent;

        switch(emailNotificationType){
            case "1":
                subject = "Welcome to BlackRock Application";
                emailContent = "";
                break;

            case "2":
                subject = "Password Updated";
                emailContent = "";
                break;

            case "3":
                subject = "Unusual Login";
                emailContent = "";
                break;

            case "4":
                subject = "Payment Due Date";
                emailContent = "";
                break;

            case "5":
                subject = "Dissolve Premium Account";
                emailContent = "";
                break;

            default:
                subject = "";
                emailContent = "";
                break;
        }

        EmailDetailsModal emailDetailsModal = new EmailDetailsModal();
        emailDetailsModal.setRecipient(userEmail);
        emailDetailsModal.setSubject(subject);
        emailDetailsModal.setMsgBody(emailContent);

        return emailService.sendSimpleMail(emailDetailsModal);
    }

    public int sendEmailAttachment(String username, String userEmail, String emailNotificationType, String attachment){

        String subject;
        String emailContent;

        switch(emailNotificationType){
            case "51":
                subject = "Welcome to BlackRock Application";
                emailContent = "";
                break;

            case "52":
                subject = "Password Updated";
                emailContent = "";
                break;

            case "53":
                subject = "Unusual Login";
                emailContent = "";
                break;

            case "54":
                subject = "Payment Due Date";
                emailContent = "";
                break;

            case "55":
                subject = "Dissolve Premium Account";
                emailContent = "";
                break;

            default:
                subject = "";
                emailContent = "";
                break;
        }

        EmailDetailsModal emailDetailsModal = new EmailDetailsModal();
        emailDetailsModal.setRecipient(userEmail);
        emailDetailsModal.setSubject(subject);
        emailDetailsModal.setMsgBody(emailContent);
        emailDetailsModal.setAttachment(attachment);

        return emailService.sendMailWithAttachment(emailDetailsModal);
    }



}
