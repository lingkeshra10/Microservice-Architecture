package com.lingkesh.microservice.EmailService.service;

import com.lingkesh.microservice.EmailService.entity.EmailServer;

public interface EmailServerService {

    boolean isSMTPExist();

    EmailServer retrieveSMTP();
}