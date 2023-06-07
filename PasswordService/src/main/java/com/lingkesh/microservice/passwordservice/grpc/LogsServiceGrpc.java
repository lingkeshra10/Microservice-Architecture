package com.lingkesh.microservice.passwordservice.grpc;

import com.microservice.proto.APIResponse;
import com.microservice.proto.LogsGrpc;
import com.microservice.proto.loginRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

public class LogsServiceGrpc {


    public void addLog(String userId, int responseCode, String remark, String grpcServerHostname, int grpcServerPort){
        System.out.println("The hostname: " + grpcServerHostname);
        System.out.println("The port: " + grpcServerPort);

        ManagedChannel channel = ManagedChannelBuilder.forAddress(grpcServerHostname, grpcServerPort).usePlaintext().build();

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
