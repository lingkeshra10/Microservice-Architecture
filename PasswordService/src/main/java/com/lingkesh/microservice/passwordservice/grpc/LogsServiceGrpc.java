package com.lingkesh.microservice.passwordservice.grpc;

import com.microservice.proto.Empty;
import com.microservice.proto.LogsGrpc;
import com.microservice.proto.addLogsParams;
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


}
