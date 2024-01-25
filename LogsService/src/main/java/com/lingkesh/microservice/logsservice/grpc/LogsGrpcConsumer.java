package com.lingkesh.microservice.logsservice.grpc;

import com.lingkesh.microservice.logsservice.entity.Log;
import com.lingkesh.microservice.logsservice.service.LogService;
import com.microservice.proto.*;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@net.devh.boot.grpc.server.service.GrpcService
public class LogsGrpcConsumer extends LogsGrpc.LogsImplBase {

    LogService logService;

    @Autowired
    public LogsGrpcConsumer(LogService logService) {
        this.logService = logService;
    }

    @Override
    public void addLogs(addLogsParams request, StreamObserver<Empty> responseObserver) {
       //super.addLogs(request, responseObserver);
        String userId = request.getUserId();
        int responseCode = request.getResponseCode();
        String remark = request.getRemark();

        logService.addLogs(userId, remark, responseCode);

        Empty emptyResponse = Empty.getDefaultInstance();

        responseObserver.onNext(emptyResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void retrieveUserLogs(retrieveUserLogsParams request, StreamObserver<APIResponse> responseObserver) {
        String userId = request.getUserId();

        List<Log> listLog = logService.retrieveUserLog(userId);

        int code= 0;
        String message = "Success";

        APIResponse response = APIResponse.newBuilder()
                .setCode(code)
                .setMessage(message)
                .setObject(listLog.toString()).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
