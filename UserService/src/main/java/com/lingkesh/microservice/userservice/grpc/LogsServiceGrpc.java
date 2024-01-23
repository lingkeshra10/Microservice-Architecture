package com.lingkesh.microservice.userservice.grpc;

import com.microservice.proto.APIResponse;
import com.microservice.proto.Empty;
import com.microservice.proto.LogsGrpc;
import com.microservice.proto.addLogsParams;
import com.microservice.proto.retrieveUserLogsParams;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class LogsServiceGrpc {

    public void addServiceLogs(long userId, int responseCode, String remark, String grpcServerHostname, int grpcServerPort){

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

    public String retrieveUserLogs(long userId, String grpcServerHostname, int grpcServerPort){

        ManagedChannel channel = ManagedChannelBuilder.forAddress(grpcServerHostname, grpcServerPort).usePlaintext().build();

        LogsGrpc.LogsBlockingStub stub = LogsGrpc.newBlockingStub(channel);

        retrieveUserLogsParams request = retrieveUserLogsParams.newBuilder()
                .setUserId(String.valueOf(userId))
                .build();

        APIResponse response = stub.retrieveUserLogs(request);

        int code = response.getCode();
        String message = response.getMessage();
        String object = response.getObject();

        System.out.println("The response code: "  + code);
        System.out.println("The response message: "  + message);
        System.out.println("The response object: "  + object);

        // Use the response data as needed
        channel.shutdown();

        return object;
    }


}
