package com.lingkesh.microservice.EmailService.service.impl;

import com.lingkesh.microservice.EmailService.entity.EmailServer;
import com.lingkesh.microservice.EmailService.repo.EmailServerRepo;
import com.lingkesh.microservice.EmailService.service.EmailServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServerServiceImpl implements EmailServerService {

    EmailServerRepo emailServerRepo;

    @Autowired
    public EmailServerServiceImpl(EmailServerRepo emailServerRepo) {
        this.emailServerRepo = emailServerRepo;
    }

    @Override
    public boolean isSMTPExist() {
        return emailServerRepo.findSMTPExist();
    }

    @Override
    public EmailServer retrieveSMTP() {
        return emailServerRepo.retrieveEmailServer();
    }
}
