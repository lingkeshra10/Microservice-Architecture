package com.lingkesh.microservice.logsservice.service.impl;

import com.lingkesh.microservice.logsservice.entity.Log;
import com.lingkesh.microservice.logsservice.repository.LogRepo;
import com.lingkesh.microservice.logsservice.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;

public class LogsServiceImpl implements LogService {

    @Autowired
    LogRepo logRepo;

    @Override
    public void addLogs(String userId, String remark, int responseCode) {

        Log log = new Log();
        log.setLog_user_id(userId);
        log.setRemark(remark);
        log.setEvent_id(responseCode);
        long currentTime = System.currentTimeMillis() / 1000L;
        log.getCreated_date(currentTime);

        logRepo.save(log);

    }
}
