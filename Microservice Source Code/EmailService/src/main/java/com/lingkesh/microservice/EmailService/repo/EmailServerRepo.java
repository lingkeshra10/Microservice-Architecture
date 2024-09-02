package com.lingkesh.microservice.EmailService.repo;

import com.lingkesh.microservice.EmailService.entity.EmailServer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailServerRepo extends JpaRepository<EmailServer, Long> {

    @Query("SELECT count(es)>0 FROM EmailServer es where es.enable = 1")
    boolean findSMTPExist();

    @Query("FROM EmailServer es WHERE es.enable = 1")
    EmailServer retrieveEmailServer();
}
