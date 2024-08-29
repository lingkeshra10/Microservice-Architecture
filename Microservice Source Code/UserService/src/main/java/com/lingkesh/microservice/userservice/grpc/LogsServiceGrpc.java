package com.lingkesh.microservice.userservice.grpc;

import com.lingkesh.microservice.userservice.modal.ResponseModal;
import com.microservice.proto.APIResponse;
import com.microservice.proto.Empty;
import com.microservice.proto.LogsGrpc;
import com.microservice.proto.addLogsParams;
import com.microservice.proto.retrieveUserLogsParams;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LogsServiceGrpc {

    @Value("${grpc.server.hostname}")
    private String grpcServerHostname;

    @Value("${grpc.server.port}")
    private int grpcServerPort;

    public void addServiceLogs(long userId, int responseCode, String remark){

        ManagedChannel channel = ManagedChannelBuilder.forAddress(grpcServerHostname, grpcServerPort).usePlaintext().build();

        LogsGrpc.LogsBlockingStub stub = LogsGrpc.newBlockingStub(channel);

        addLogsParams request = addLogsParams.newBuilder()
                .setUserId(String.valueOf(userId))
                .setResponseCode(responseCode)
                .setRemark(remark)
                .build();

        Empty response = stub.addLogs(request);

        // Use the response data as needed
        channel.shutdown();
    }

    public ResponseModal retrieveUserLogs(long userId, String grpcServerHostname, int grpcServerPort){

        ResponseModal responseModal = new ResponseModal();

        ManagedChannel channel = ManagedChannelBuilder.forAddress(grpcServerHostname, grpcServerPort).usePlaintext().build();

        LogsGrpc.LogsBlockingStub stub = LogsGrpc.newBlockingStub(channel);

        retrieveUserLogsParams request = retrieveUserLogsParams.newBuilder()
                .setUserId(String.valueOf(userId))
                .build();

        APIResponse response = stub.retrieveUserLogs(request);

        int code = response.getCode();
        String message = response.getMessage();
        String object = response.getObject();

        // Use the response data as needed
        channel.shutdown();

        responseModal.setCode(code);
        responseModal.setMessage(message);
        responseModal.setObject(object);

        return responseModal;
    }


}
