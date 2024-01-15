package com.lingkesh.microservice.logsservice.service;

import com.lingkesh.microservice.logsservice.entity.Log;

public interface LogService {

    void addLogs(String userId, String remark, int responseCode);

    Log retrieveUserLog(String userId);
}
