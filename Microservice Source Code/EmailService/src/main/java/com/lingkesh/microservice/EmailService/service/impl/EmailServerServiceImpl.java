package com.lingkesh.microservice.EmailService.service.impl;

import com.lingkesh.microservice.EmailService.entity.EmailServer;
import com.lingkesh.microservice.EmailService.repo.EmailServerRepo;
import com.lingkesh.microservice.EmailService.service.EmailServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class EmailServerServiceImpl implements EmailServerService {
    EmailServerRepo emailServerRepo;
    RedisTemplate<String, EmailServer> redisTemplate;
    private static final String SMTP_CACHE_KEY = "smtpDetails";

    @Autowired
    public EmailServerServiceImpl(EmailServerRepo emailServerRepo, RedisTemplate<String, EmailServer> redisTemplate) {
        this.emailServerRepo = emailServerRepo;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean isSMTPExist() {
        return emailServerRepo.findSMTPExist();
    }

    @Override
    public EmailServer retrieveSMTP() {
        // Try to get SMTP details from Redis cache
        EmailServer smtpDetails = redisTemplate.opsForValue().get(SMTP_CACHE_KEY);

        if (smtpDetails != null) {
            // SMTP details found in Redis, return them
            System.out.println("Retrieved SMTP details from Redis.");
            return smtpDetails;
        }

        // If not found in Redis, fetch from database
        System.out.println("SMTP details not found in Redis, fetching from DB.");
        smtpDetails = emailServerRepo.retrieveEmailServer();

        if (smtpDetails != null) {
            // Store the SMTP details in Redis for future use, set an expiration time (optional)
            redisTemplate.opsForValue().set(SMTP_CACHE_KEY, smtpDetails, 60, TimeUnit.MINUTES);  // Cache for 60 minutes
            System.out.println("Stored SMTP details in Redis.");
        }

        //return emailServerRepo.retrieveEmailServer();
        return smtpDetails;
    }
}
