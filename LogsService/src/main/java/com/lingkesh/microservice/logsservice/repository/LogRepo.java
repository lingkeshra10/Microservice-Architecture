package com.lingkesh.microservice.logsservice.repository;

import com.lingkesh.microservice.logsservice.entity.Log;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableMongoRepositories
public interface LogRepo extends MongoRepository<Log, Long> {

    //List<Log> retrieveUserLog(String log_user_id);

    @Query("{ 'logUserId': ?0 }")
    List<Log> findByLogUserId(String logUserId);

}
