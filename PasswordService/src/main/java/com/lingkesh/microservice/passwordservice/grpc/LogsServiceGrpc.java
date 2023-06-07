package com.lingkesh.microservice.passwordservice.grpc;

import com.microservice.proto.APIResponse;
import com.microservice.proto.LogsGrpc;
import com.microservice.proto.loginRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class LogsServiceGrpc {

    public void addLog(String userId, int responseCode, String remark){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8310).usePlaintext().build();

        LogsGrpc.LogsBlockingStub stub = LogsGrpc.newBlockingStub(channel);

        loginRequest request = loginRequest.newBuilder()
                .setUsername("user123")
                .setPassword("password123")
                .build();

        APIResponse response = stub.login(request);

        int code = response.getCode();
        String message = response.getMessage();

        System.out.println("The response code: "  + code);
        System.out.println("The response message: "  + message);

        // Use the response data as needed
        channel.shutdown();
    }


}
