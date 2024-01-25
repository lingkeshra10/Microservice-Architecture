package com.lingkesh.microservice.logsservice.grpc;

import com.lingkesh.microservice.logsservice.entity.Log;
import com.lingkesh.microservice.logsservice.service.LogService;
import com.microservice.proto.*;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;

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

        System.out.println("THE userId IS SHOWING: " + userId);
        System.out.println("THE responseCode IS SHOWING: " + responseCode);
        System.out.println("THE remark IS SHOWING: " + remark);

        logService.addLogs(userId, remark, responseCode);

        Empty emptyResponse = Empty.getDefaultInstance();

        responseObserver.onNext(emptyResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void retrieveUserLogs(retrieveUserLogsParams request, StreamObserver<APIResponse> responseObserver) {
        String userId = request.getUserId();

        System.out.println("THE userId IS SHOWING: " + userId);

        Log log = logService.retrieveUserLog(userId);

        int code= 0;
        String message = "Success";
        String object = "This is Object";

        APIResponse response = APIResponse.newBuilder()
                .setCode(code)
                .setMessage(message)
                .setObject(object).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
