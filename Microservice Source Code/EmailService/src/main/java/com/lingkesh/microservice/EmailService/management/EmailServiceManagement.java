package com.lingkesh.microservice.EmailService.management;

import com.lingkesh.microservice.EmailService.entity.EmailServer;
import com.lingkesh.microservice.EmailService.modal.ResponseModal;
import com.lingkesh.microservice.EmailService.service.EmailServerService;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.internet.MimeMessage;
import org.eclipse.angus.mail.util.MailSSLSocketFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.security.GeneralSecurityException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceManagement {

    EmailServerService emailServerService;
    private static final int DEFAULT_TIMEOUT = 15000;
    private static final Logger logger = LogManager.getLogger(EmailServiceManagement.class);

    @Autowired
    public EmailServiceManagement(EmailServerService emailServerService) {
        this.emailServerService = emailServerService;
    }

    public JavaMailSender getJavaMailSender(EmailServer emailServer) throws GeneralSecurityException {
        String emailHost = emailServer.getHost();
        int emailPort = emailServer.getPort();
        String emailUsername = emailServer.getUsername();
        String emailPassword = emailServer.getPassword();
        boolean sslEnable = emailServer.getSsl_enable() == 1;
        boolean tlsEnable = emailServer.getTls_enable() == 1;
        boolean debugEnable = emailServer.getDebug_mode() == 1;
        boolean requireAuthEnable = emailServer.getRequire_authentication() == 1;

        Properties props = new Properties();
        props.put("mail.smtp.host", emailHost);
        props.put("mail.smtp.port", Integer.toString(emailPort));
        props.put("mail.smtp.debug", Boolean.toString(debugEnable));
        props.put("mail.smtp.auth", Boolean.toString(requireAuthEnable));
        props.put("mail.smtp.user", emailUsername);
        props.put("mail.smtp.starttls.enable", Boolean.toString(tlsEnable));
        props.put("mail.smtp.ssl.enable", Boolean.toString(sslEnable));
        props.put("mail.smtp.connectiontimeout", Integer.toString(DEFAULT_TIMEOUT));
        props.put("mail.smtp.timeout", Integer.toString(DEFAULT_TIMEOUT));

        if (tlsEnable || sslEnable) {
            MailSSLSocketFactory socketFactory = new MailSSLSocketFactory();
            socketFactory.setTrustAllHosts(true);
            props.put("mail.smtp.ssl.trust", "*");
            props.put("mail.imaps.ssl.socketFactory", socketFactory);
            props.put("mail.smtp.ssl.socketFactory", socketFactory);
            props.put("mail.smtps.ssl.socketFactory", socketFactory);
        }

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(emailHost);
        mailSender.setPort(emailPort);
        mailSender.setUsername(emailUsername);
        mailSender.setPassword(emailPassword);

        if (requireAuthEnable) {
            Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(emailUsername, emailPassword);
                }
            });
            session.setDebug(debugEnable);
            mailSender.setSession(session);
        } else {
            mailSender.setJavaMailProperties(props);
        }

        return mailSender;
    }

    public int sendHtmlEmail(String username, String notificationEmail, String emailNotificationType) {
        try {
            //First Check Client have SMTP or not
            boolean ifExistClientSMTP = emailServerService.isSMTPExist();

            EmailServer emailServer;
            if(ifExistClientSMTP){
                logger.info("Have SMTP Server");
                emailServer = emailServerService.retrieveSMTP();
            }else{
                logger.error("Failed to send email due to no SMTP settings has been set");
                return ResponseModal.EMAIL_SEND_FAIL;
            }

            String subject = "";
            String emailContent = "";
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
            }

            String senderUsername = emailServer.getSender();
            JavaMailSender mailSender = getJavaMailSender(emailServer);

            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(subject, true);
            helper.setTo(notificationEmail);
            helper.setSubject(emailContent);
            helper.setFrom(senderUsername);

            mailSender.send(mimeMessage);
            logger.info("Successfully able to send email");
            return ResponseModal.EMAIL_SEND_SUCCESS; // Email sent successfully
        }catch (MailException | MessagingException | GeneralSecurityException e) {
            // Handle the exception (log it, rethrow it, etc.)
            logger.error("Failed to send email: " + e.getMessage());
            return ResponseModal.EMAIL_SEND_FAIL; // Email sending failed
        }
    }
}
