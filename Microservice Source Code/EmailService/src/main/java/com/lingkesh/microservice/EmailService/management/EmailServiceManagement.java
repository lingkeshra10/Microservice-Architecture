package com.lingkesh.microservice.EmailService.management;

import com.lingkesh.microservice.EmailService.modal.ResponseModal;

public class EmailServiceManagement {

    public int sendEmail(String username, String userEmail, String emailNotificationType){

        String subject;
        String emailContent;

        switch(emailNotificationType){
            case "1":
                subject = "Welcome to BlackRock Application";
                emailContent = "Hai, " + username + " thank you for choosing our applications.";
                break;

            case "2":
                subject = "Password Updated";
                emailContent = "Hai, " + username + " we have successfully updated password for your account. " +
                        "If you didnt perform this action please contact the administrator.";
                break;

            case "3":
                subject = "Unusual Login";
                emailContent = "Hai, " + username + " we have detected unusual login to your application.";
                break;

            case "4":
                subject = "Payment Due Date";
                emailContent = "Hai, " + username + " we have notice your account reach due date for the payment. " +
                        "Please perform your payment for continuing your premium version";
                break;

            case "5":
                subject = "Dissolve Premium Account";
                emailContent = "Hai, " + username + " due to the payment for the account not been paid. " +
                        "We will degrade your account. " +
                        "If there is any inquiry please contact our administrator.";
                break;

            default:
                subject = "";
                emailContent = "";
                break;
        }

        System.out.println("Recipient: " + username + " with the user email: " + userEmail +
                " have successfully sent email with subject: " + subject + "and email content: " + emailContent);
        return ResponseModal.EMAIL_SEND_SUCCESS;
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

        System.out.println("Recipient: " + username + " with the user email: " + userEmail +
                " have successfully sent email with subject: " + subject + "and email content: " + emailContent
                + " with attachment:" + attachment);
        return ResponseModal.EMAIL_SEND_SUCCESS;
    }



}
