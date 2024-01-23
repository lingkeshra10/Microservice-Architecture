package com.lingkesh.microservice.logsservice.service.impl;

import com.lingkesh.microservice.logsservice.entity.Log;
import com.lingkesh.microservice.logsservice.repository.LogRepo;
import com.lingkesh.microservice.logsservice.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LogsServiceImpl implements LogService {

    @Autowired
    LogRepo logRepo;

    @Override
    public void addLogs(String userId, String remark, int responseCode) {
        Log log = new Log();
        log.setLogUserId(userId);
        log.setRemark(remark);
        log.setEventId(responseCode);
        long currentTime = System.currentTimeMillis() / 1000L;
        log.setCreated_date(currentTime);

        logRepo.save(log);
    }

    @Override
    public Log retrieveUserLog(String userId) {

        List<Log> retrieveUserListLog = logRepo.findByLogUserId(userId);

        // Check if the list is not empty
        if (!retrieveUserListLog.isEmpty()) {
            // Get the LogDetails of the first Log in the list
            return retrieveUserListLog.get(0);
        } else {
            // Handle the case when the list is empty (e.g., return null or throw an exception)
            return null;
        }
    }
}
