package com.lingkesh.microservice.logsservice.service;

import com.lingkesh.microservice.logsservice.entity.Log;

import java.util.List;

public interface LogService {

    void addLogs(String userId, String remark, int responseCode);

    List<Log> retrieveUserLog(String userId);
}
