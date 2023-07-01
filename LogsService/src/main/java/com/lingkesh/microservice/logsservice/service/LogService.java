package com.lingkesh.microservice.logsservice.service;

public interface LogService {

    void addLogs(String userId, String remark, int responseCode);

}
