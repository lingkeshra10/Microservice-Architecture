package com.lingkesh.microservice.userservice.grpc;

import com.microservice.proto.APIResponse;
import com.microservice.proto.LogsGrpc;
import com.microservice.proto.addLogs;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class LogsServiceGrpc {

    public void addServiceLogs(long userId, int responseCode, String remark, String grpcServerHostname, int grpcServerPort){

        ManagedChannel channel = ManagedChannelBuilder.forAddress(grpcServerHostname, grpcServerPort).usePlaintext().build();

        LogsGrpc.LogsBlockingStub stub = LogsGrpc.newBlockingStub(channel);

        addLogs request = addLogs.newBuilder()
                .setUserId(String.valueOf(userId))
                .setResponseCode(responseCode)
                .setRemark(remark)
                .build();

        APIResponse response = stub.logs(request);

        int code = response.getCode();
        String message = response.getMessage();

        System.out.println("The response code: "  + code);
        System.out.println("The response message: "  + message);

        // Use the response data as needed
        channel.shutdown();
    }


}
